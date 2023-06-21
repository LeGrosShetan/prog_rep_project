package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.OeuvreventeEntity;
import com.epul.oeuvre.mesExceptions.MonException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import java.util.List;

public class ServiceOeuvreVente {
    public OeuvreventeEntity consulterOeuvreVente(int id) throws MonException {
        List<OeuvreventeEntity> mesOeuvresVentes = null;
        OeuvreventeEntity uneOeuvreVente = null;
        String marequete = "SELECT o FROM OeuvreventeEntity o WHERE o.idOeuvrevente = " + id;
        try {
            Session session = ServiceHibernate.currentSession();
            TypedQuery<OeuvreventeEntity> query = session.createQuery(marequete);
            mesOeuvresVentes = query.getResultList();
            uneOeuvreVente = mesOeuvresVentes.get(0);
            session.close();
        } catch (MonException e){
            throw e;}
        catch (HibernateException ex) {
            throw new MonException("test", "Impossible d'acc�der � la SessionFactory: ",  ex.getMessage());
        }
        return uneOeuvreVente;
    }
}