package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.OeuvreventeEntity;
import com.epul.oeuvre.domains.ProprietaireEntity;
import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.oeuvre.repositories.OeuvreRepository;
import com.epul.oeuvre.repositories.ProprietaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OeuvreService implements  IOeuvreService {


    // on initialise à travers le constructeur

    @Autowired
    private OeuvreRepository uneOeuvreRepository;
    @Autowired
    private ProprietaireRepository unProprietaireRepository;

    @Override
    public void inserer(OeuvreventeEntity uneOV) {
        try {

            ProprietaireEntity unProprio = new ProprietaireEntity();
            ProprietaireEntity finalUnProprio = unProprio;
            unProprio = unProprietaireRepository.findById(uneOV.getIdProprietaire()).orElseThrow(
                    () -> new MonException("¨Proprietaire", "id", finalUnProprio.getIdProprietaire())
            );
            uneOV.setIdProprietaire(unProprio.getIdProprietaire());
            this.uneOeuvreRepository.save(uneOV);
        } catch (Exception e) {
            throw new MonException("Insert", "Sql", e.getMessage());
        }
    }
    private Sort sortByTitre() {
        return new Sort(Sort.Direction.ASC, "titreOeuvrevente");
    }

    // on liste toutes les oeuvre
    @Override
    public List<OeuvreventeEntity> getToutesLesOeuvres() {
        List<OeuvreventeEntity> mesOeuvres=null;
        try {

            mesOeuvres =uneOeuvreRepository.findAll(sortByTitre());
        } catch (Exception e) {
            throw new MonException("Insert", "Sql", e.getMessage());
        }
        return mesOeuvres;
    }
    @Override
    public OeuvreventeEntity getUneOeuvreID(int id) {
        return uneOeuvreRepository.findById(id).orElseThrow(
                () -> new MonException("Client", "id", id)
        );
    }

}
