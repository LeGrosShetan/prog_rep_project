package com.epul.permispiste.service;

import com.epul.permispiste.domains.JeuEntity;

import java.util.Set;

public interface IJeuService {

    public Set<JeuEntity> getTousLesJeux();

    public Set<JeuEntity> getTousLesJeuxApprenant(int numApprenant);

    public JeuEntity getUnJeuNum(int numJeu);
}
