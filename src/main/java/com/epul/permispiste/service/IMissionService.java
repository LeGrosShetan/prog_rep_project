package com.epul.permispiste.service;

import com.epul.permispiste.domains.MissionEntity;

import java.util.Set;

public interface IMissionService {

    public Set<MissionEntity> getToutesLesMission();

    public Set<MissionEntity> getToutesLesMissionJeu(int numJeu);

    public MissionEntity getUneMissionNum(int numMission);
}
