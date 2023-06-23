package com.epul.permispiste.service;

import com.epul.permispiste.domains.ObjectifEntity;

import java.util.Set;

public interface IObjectifService {

    public Set<ObjectifEntity> getTousLesObjectifs();

    public Set<ObjectifEntity> getTousLesObjectifsMission(int numMission);

    public ObjectifEntity getUnObjectifNum(int numObjectif);
}
