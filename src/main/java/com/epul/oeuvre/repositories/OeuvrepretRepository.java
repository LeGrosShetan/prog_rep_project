package com.epul.oeuvre.repositories;

import com.epul.oeuvre.domains.OeuvrepretEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OeuvrepretRepository extends JpaRepository<OeuvrepretEntity, Integer> {



}


