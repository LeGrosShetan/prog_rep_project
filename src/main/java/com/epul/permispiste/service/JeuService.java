package com.epul.permispiste.service;

import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.permispiste.domains.ApprenantEntity;
import com.epul.permispiste.domains.JeuEntity;
import com.epul.permispiste.repositories.JeuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class JeuService {

    @Autowired
    private JeuRepository unJeuRepository;

    /**
     * Tri tous les jeux par ordre alphabétique.
     * @return Une liste triée de tous les jeux.
     */
    private Sort sortByNom() {
        return new Sort(Sort.Direction.ASC, "libelleJeu");
    }

    /**
     * Liste tous les jeux.
     * @return La liste de tous les jeux.
     */
    public Set<JeuEntity> getTousLesJeux() {

        List<JeuEntity> mesJeux = null;
        try {
            mesJeux = unJeuRepository.findAll(sortByNom());
        } catch (Exception e) {
            throw new MonException("Insert", "Sql", e.getMessage());
        }
        return (Set<JeuEntity>) mesJeux;
    }

    public List<JeuEntity> getTousLesJeuxApprenant(int numApprenant){
        return null;
    }

    /**
     * Cherche un jeu par son numéro de jeu.
     * @param numJeu Le numéro du jeu.
     * @return Le jeu correspondant au numJeu.
     */
    public JeuEntity getUnJeuNum(int numJeu){
        return unJeuRepository.findById(numJeu).orElseThrow(
                () -> new MonException("Client", "numJeu", numJeu)
        );
    }
}
