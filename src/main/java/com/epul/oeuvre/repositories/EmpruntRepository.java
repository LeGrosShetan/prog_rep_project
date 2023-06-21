package com.epul.oeuvre.repositories;

import com.epul.oeuvre.domains.EmpruntEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpruntRepository extends JpaRepository<EmpruntEntity, Integer> {

}
