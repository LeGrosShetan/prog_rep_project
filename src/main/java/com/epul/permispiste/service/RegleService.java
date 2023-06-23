package com.epul.permispiste.service;

import com.epul.permispiste.mesExceptions.MonException;
import com.epul.permispiste.domains.RegleEntity;
import com.epul.permispiste.repositories.RegleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RegleService implements IRegleService{

    @Autowired
    private RegleRepository uneRegleRepository;

    /**
     * Tri tous les jeux par ordre alphabétique.
     * @return Une liste triée de tous les jeux.
     */
    public Sort sortByNom() {
        return new Sort(Sort.Direction.ASC, "libRegle");
    }

    public Set<RegleEntity> getToutesLesRegles() {
        List<RegleEntity> mesRegles = null;

        try {
            mesRegles = uneRegleRepository.findAll(sortByNom());
        } catch (Exception e) {
            throw new MonException("Insert", "Sql", e.getMessage());
        }

        return (Set<RegleEntity>) mesRegles;
    }

    public RegleEntity getUneRegleNum(int numRegle) {
        return uneRegleRepository.findById(numRegle).orElseThrow(
                () -> new MonException("Client", "numRegle", numRegle)
        );
    }
}
