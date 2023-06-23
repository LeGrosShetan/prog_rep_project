package com.epul.permispiste.service;

import com.epul.permispiste.mesExceptions.MonException;
import com.epul.permispiste.domains.ObjectifEntity;
import com.epul.permispiste.repositories.ObjectifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ObjectifService {

    @Autowired
    private ObjectifRepository unObjectifRepository;

    /**
     * Tri tous les jeux par ordre alphabétique.
     * @return Une liste triée de tous les jeux.
     */
    private Sort sortByNom() {
        return new Sort(Sort.Direction.ASC, "libObjectif");
    }

    /**
     * Liste tous les jeux.
     * @return La liste de tous les jeux.
     */
    public Set<ObjectifEntity> getTousLesObjectifs() {

        List<ObjectifEntity> mesObjectifs = null;
        try {
            mesObjectifs = unObjectifRepository.findAll(sortByNom());
        } catch (Exception e) {
            throw new MonException("Insert", "Sql", e.getMessage());
        }
        return (Set<ObjectifEntity>) mesObjectifs;
    }

    public Set<ObjectifEntity> getTousLesObjectifsMission(int numMission){
        return null;
    }

    /**
     * Cherche un jeu par son numéro de jeu.
     * @param numObjectif Le numéro du jeu.
     * @return Le jeu correspondant au numJeu.
     */
    public ObjectifEntity getUnObjectifNum(int numObjectif){
        return unObjectifRepository.findById(numObjectif).orElseThrow(
                () -> new MonException("Client", "numbjectif", numObjectif)
        );
    }
}
