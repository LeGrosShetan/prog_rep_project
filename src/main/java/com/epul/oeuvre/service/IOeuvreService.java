package com.epul.oeuvre.service;


import com.epul.oeuvre.domains.OeuvreventeEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOeuvreService {

    public void inserer(OeuvreventeEntity unOV);
    public List<OeuvreventeEntity> getToutesLesOeuvres();

    public OeuvreventeEntity getUneOeuvreID(int id);
}
