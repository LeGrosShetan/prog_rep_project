package com.epul.permispiste.service;

import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.permispiste.domains.JeuEntity;
import com.epul.permispiste.domains.MissionEntity;
import com.epul.permispiste.repositories.JeuRepository;
import com.epul.permispiste.repositories.MissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;

@Service
public class MissionService {

    @Autowired
    private MissionRepository uneMissionRepository;

    /**
     * Tri tous les jeux par ordre alphabétique.
     * @return Une liste triée de tous les jeux.
     */
    private Sort sortByNom() {
        return new Sort(Sort.Direction.ASC, "libMission");
    }

    /**
     * Liste tous les jeux.
     * @return La liste de tous les jeux.
     */
    public Set<MissionEntity> getToutesLesMissions() {

        List<MissionEntity> mesMissions = null;
        try {
            mesMissions = uneMissionRepository.findAll(sortByNom());
        } catch (Exception e) {
            throw new MonException("Insert", "Sql", e.getMessage());
        }
        return (Set<MissionEntity>) mesMissions;
    }

    public Set<MissionEntity> getToutesLesMissionsJeu(int numJeu){
        return null;
    }

    /**
     * Cherche un jeu par son numéro de jeu.
     * @param numMission Le numéro du jeu.
     * @return Le jeu correspondant au numJeu.
     */
    public MissionEntity getUneMissionNum(int numMission){
        return uneMissionRepository.findById(numMission).orElseThrow(
                () -> new MonException("Client", "numMission", numMission)
        );
    }
}
