package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.AdherentEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
interface IAdherentService {


    public List<AdherentEntity> getTousLesAdherents();

    public AdherentEntity getUnAdherentID(int id);

    public void ajouterClient(AdherentEntity unC);

}