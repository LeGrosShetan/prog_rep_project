package com.epul.permispiste.service;

import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.permispiste.domains.JeuEntity;
import com.epul.permispiste.domains.MissionEntity;
import com.epul.permispiste.repositories.MissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;

@Service
public class MissionService {

    @Autowired
    private MissionRepository missionRepository;

    public List<MissionEntity> getAllMissions(){
        List<MissionEntity> mesMissions = null;

        try{
            mesMissions = missionRepository.findAll(Sort.by("libMission"));
        } catch (Exception e) {
            throw new MonException("Insert", "Sql", e.getMessage());
        }

        return mesMissions;
    }

    public Set<MissionEntity> getAllMissionsFromJeu(JeuEntity jeu){
        return jeu.getMissions();
    }
}
