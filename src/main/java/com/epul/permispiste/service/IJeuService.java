package com.epul.permispiste.service;

import com.epul.permispiste.domains.JeuEntity;

import java.util.List;

public interface IJeuService {

    public List<JeuEntity> getTousLesJeux();

    public List<JeuEntity> getTousLesJeuxApprenant(int numApprenant);

    public JeuEntity getUnJeuNum(int numJeu);
}
