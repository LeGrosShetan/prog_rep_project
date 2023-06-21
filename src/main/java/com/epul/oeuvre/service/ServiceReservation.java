package com.epul.oeuvre.service;

import com.epul.oeuvre.service.ServiceOeuvreVente;
import com.epul.oeuvre.service.ServiceProprietaire;
import com.epul.oeuvre.service.ServiceHibernate;
import com.epul.oeuvre.domains.OeuvreventeEntity;
import com.epul.oeuvre.domains.ProprietaireEntity;
import com.epul.oeuvre.domains.ReservationEntity;
import com.epul.oeuvre.domains.AdherentEntity;
import com.epul.oeuvre.dto.ReservationDto;
import com.epul.oeuvre.mesExceptions.MonException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class ServiceReservation {
    public List<ReservationEntity> listerReservations() throws MonException {
        List<ReservationEntity> mesReservations = null;
        String marequete = "SELECT r FROM ReservationEntity r ORDER BY r.idOeuvrevente";
        try {
            Session session = ServiceHibernate.currentSession();
            TypedQuery<ReservationEntity> query = session.createQuery(marequete);
            mesReservations = query.getResultList();
            session.close();
        } catch (MonException e){
            throw e;}
        catch (HibernateException ex) {
            throw new MonException("test","Impossible d'acc�der � la SessionFactory: ",  ex.getMessage());
        }
        return mesReservations;
    }

    public List<Object[]> consulterReservations() throws MonException {
        List<Object[]> rs = new ArrayList<>();
        List<ReservationEntity> mesReservations = null;
        int index = 0;

        try {
            mesReservations = listerReservations();

            ServiceOeuvreVente unOeuvreVenteService = new ServiceOeuvreVente();
            ServiceProprietaire unProprietaireService = new ServiceProprietaire();

            while (index < mesReservations.size()){
                Object[] item = new Object[2];
                ReservationEntity uneR = mesReservations.get(index);


                int idOeuvreVente = uneR.getIdOeuvrevente();
                OeuvreventeEntity uneOeuvreVente = unOeuvreVenteService.consulterOeuvreVente(idOeuvreVente);

                ProprietaireEntity unProprietaire = unProprietaireService.consulterProprietaire(uneOeuvreVente.getIdProprietaire());

                item[0] = (Object) uneR;
                item[1] = (Object) unProprietaire;
                rs.add(item);


                index++;
            }
            return rs;
        } catch (MonException e){
            throw e;
        } catch (HibernateException ex) {
            throw new MonException("test", "Impossible d'acc�der � la SessionFactory: ",  ex.getMessage());
        }
    }

    public List<ReservationDto> consulterListeReservationsDto() throws MonException {
        String hql = "SELECT A.nomAdherent, A.prenomAdherent, A.villeAdherent,";
        hql += "O.etatOeuvrevente, O.titreOeuvrevente, O.prixOeuvrevente,";
        hql += "P.nomProprietaire, P.prenomProprietaire, R.dateReservation ";
        hql += "FROM AdherentEntity as A ";
        hql += "JOIN ReservationEntity as R ON A.idAdherent = R.idAdherent ";
        hql += "JOIN OeuvreVenteEntity as O ON O.idOeuvrevente = R.idOeuvrevente ";
        hql += "JOIN ProprietaireEntity as P ON P.idProprietaire = R.oeuvreventeByIdOeuvrevente.idProprietaire ";
        hql += " ORDER BY R.dateReservation";

        List<ReservationDto> mesReservations = null;
        try {
            Session session = ServiceHibernate.currentSession();
            TypedQuery<ReservationDto> query = session.createQuery(hql);
            mesReservations = (List<ReservationDto>) query.getResultList();
            session.close();
        } catch (MonException e){
            throw e;}
        catch (HibernateException ex) {
            throw new MonException("test", "Impossible d'acc�der � la SessionFactory: ",  ex.getMessage());
        }
        return mesReservations;
    }
}