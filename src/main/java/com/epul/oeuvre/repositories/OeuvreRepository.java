package com.epul.oeuvre.repositories;

import com.epul.oeuvre.domains.OeuvreventeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OeuvreRepository
        extends JpaRepository<OeuvreventeEntity, Integer> {

}


