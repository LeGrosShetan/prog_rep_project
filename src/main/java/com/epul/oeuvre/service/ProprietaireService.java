package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.ProprietaireEntity;
import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.oeuvre.repositories.ProprietaireRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProprietaireService implements IProprietaireService {

    @Autowired
    private ProprietaireRepository unProprietaireRepository;

    public ProprietaireEntity getUnProprietaireID(int id) {
        return unProprietaireRepository.findById(id).orElseThrow(
                () -> new MonException("Client", "id", id)
        );
    }

}
