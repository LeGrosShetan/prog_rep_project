package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.AdherentEntity;
import com.epul.oeuvre.domains.EmpruntEntity;
import com.epul.oeuvre.domains.OeuvrepretEntity;
import com.epul.oeuvre.domains.ProprietaireEntity;
import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.oeuvre.repositories.AdherentRepository;
import com.epul.oeuvre.repositories.EmpruntRepository;
import com.epul.oeuvre.repositories.OeuvrepretRepository;
import com.epul.oeuvre.repositories.ProprietaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EmpruntService implements IEmpruntService {

    // On déclare les repository
    @Autowired
    private EmpruntRepository unEmpruntRepository;
    @Autowired
    private OeuvrepretRepository uneOeuvrePretRepository;
    @Autowired
    private ProprietaireRepository unProprietaireRepository;
    @Autowired
    private AdherentRepository unAdherentRepository;

   private Sort sortByDate() {
        return new Sort(Sort.Direction.ASC, "dateEmprunt");
    }

    // on liste tous emprunts
    @Override
    public List<EmpruntEntity> getTousLesEmprunts() {

        List<EmpruntEntity> mesEmprunts=null;
        try {
            mesEmprunts= unEmpruntRepository.findAll(sortByDate());
           // mesEmprunts= unEmpruntRepository.findAll();
        } catch (Exception e) {
            throw new MonException("Tri", "Sql", e.getMessage());
        }
        return mesEmprunts;
    }


    public  List<Object[]> consulterTouslesEmprunts() throws MonException {
        List<Object[]> rs = new ArrayList<Object[]>();
        List<EmpruntEntity> mesEmprunts;
        int index = 0;
        try {
            mesEmprunts = this.getTousLesEmprunts();
            while (index < mesEmprunts.size()) {
                EmpruntEntity unE = mesEmprunts.get(index);
                // on récupère l'oeuvre en emprunt
                // et on recherche le propriétaire
                // on récupère l'adhérent Emprunteur
                int idOeuvrepret= unE.getIdOeuvrepret();
                // on récupère l'oeuvre en prêt
                OeuvrepretEntity uneOeuvrepret  = uneOeuvrePretRepository.findById(idOeuvrepret).orElseThrow(
                        () -> new MonException("¨Ouvrepret", "id",uneOeuvrePretRepository.findById(idOeuvrepret) )
                );
                // on récupère le propriétaire
                int idProprietaire  =uneOeuvrepret.getIdProprietaire();
                ProprietaireEntity unProprietaire = unProprietaireRepository.findById(idProprietaire).orElseThrow(
                        () -> new MonException("¨Proprietaire", "id",
                                unProprietaireRepository.findById(idProprietaire))
                );
                // on récupère l'adhérent
                int idAdherent = unE.getIdAdherent();
                AdherentEntity unAdherent = unAdherentRepository.findById(idAdherent).orElseThrow(
                        () -> new MonException("¨Adhérent", "id", unAdherentRepository.findById(idAdherent))
                );
                Object[]  item = new Object[4];
                item[0]= (Object) unE;
                item[1]=(Object) unAdherent;
                item[2]=(Object) uneOeuvrepret;
                item[3]=(Object) unProprietaire;
               rs.add(item);
                index++;
            }
            return rs;
        } catch (Exception exc) {
            throw new MonException(exc.getMessage(), "systeme", "ConsulterEmprunt");
        }
    }
}
