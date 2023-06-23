package com.epul.permispiste.service;

import com.epul.permispiste.domains.ApprenantEntity;

import java.util.List;

public interface IApprenantService {

    public void ajouterApprenant(ApprenantEntity apprenant);

    public void modifierApprenant(int numApprenant);

    public List<ApprenantEntity> getTousLesApprenants();

    public ApprenantEntity getUnApprenantNum(int numApprenant);
}
