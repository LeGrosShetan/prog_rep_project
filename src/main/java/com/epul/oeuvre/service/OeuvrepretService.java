package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.OeuvrepretEntity;
import com.epul.oeuvre.mesExceptions.MonException;
import org.springframework.beans.factory.annotation.Autowired;
import com.epul.oeuvre.repositories.OeuvrepretRepository;

public class OeuvrepretService implements IOeuvrepretService  {

    @Autowired
    private OeuvrepretRepository uneOeuvrepretRepository;

    public OeuvrepretEntity getUneOeuvrepretID(int id) {
        return uneOeuvrepretRepository.findById(id).orElseThrow(
                () -> new MonException("Client", "id", id)
        );
    }
}
