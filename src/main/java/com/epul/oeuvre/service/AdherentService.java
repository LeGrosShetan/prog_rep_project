package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.AdherentEntity;
import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.oeuvre.repositories.AdherentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdherentService implements IAdherentService {

    @Autowired
    private AdherentRepository unAdherentRepository;

    private Sort sortByNom() {
        return new Sort(Sort.Direction.ASC, "nomAdherent");
    }
    // on liste tous les adhérents au format json
    @Override
    public List<AdherentEntity> getTousLesAdherents() {

            List<AdherentEntity> mesAdherents=null;
            try {

                mesAdherents= unAdherentRepository.findAll(sortByNom());
            } catch (Exception e) {
                throw new MonException("Insert", "Sql", e.getMessage());
            }
            return mesAdherents;
        }


    public AdherentEntity getUnAdherentID(int id) {
        return unAdherentRepository.findById(id).orElseThrow(
                () -> new MonException("Client", "id", id)
        );
    }

    // on insère un adhérent
    @Override
    public void ajouterClient(AdherentEntity unA) {
        try {
            unAdherentRepository.save(unA);
        } catch (Exception e) {
            throw new MonException("Insert", "Sql", e.getMessage());
        }
    }
}
