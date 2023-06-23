package com.epul.permispiste.service;

import com.epul.permispiste.domains.ApprenantEntity;

import java.util.Set;

public interface IApprenantService {

    public void ajouterApprenant(ApprenantEntity apprenant);

    public void modifierApprenant(int numApprenant);

    public Set<ApprenantEntity> getTousLesApprenants();

    public ApprenantEntity getUnApprenantNum(int numApprenant);
}
