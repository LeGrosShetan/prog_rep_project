package com.epul.oeuvre.repositories;


import com.epul.oeuvre.domains.ProprietaireEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProprietaireRepository
        extends JpaRepository<ProprietaireEntity, Integer> {

}

