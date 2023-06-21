package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.ProprietaireEntity;
import com.epul.oeuvre.mesExceptions.MonException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import java.util.List;

public class ServiceProprietaire {
    public ProprietaireEntity consulterProprietaire(int id) throws MonException{
        List<ProprietaireEntity> mesProprietaires = null;
        ProprietaireEntity unProprietaire = null;
        String marequete = "SELECT p FROM ProprietaireEntity p WHERE p.idProprietaire = " + id;
        try {
            Session session = ServiceHibernate.currentSession();
            TypedQuery<ProprietaireEntity> query = session.createQuery(marequete);
            mesProprietaires = query.getResultList();
            unProprietaire = mesProprietaires.get(0);
            session.close();
        } catch (MonException e){
            throw e;}
        catch (HibernateException ex) {
            throw new MonException("test", "Impossible d'acc�der � la SessionFactory: ",  ex.getMessage());
        }
        return unProprietaire;
    }
}