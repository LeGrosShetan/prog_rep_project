package com.epul.oeuvre.repositories;


import com.epul.oeuvre.domains.AdherentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdherentRepository extends JpaRepository<AdherentEntity, Integer> {

}

