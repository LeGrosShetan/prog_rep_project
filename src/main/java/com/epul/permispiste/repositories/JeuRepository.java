package com.epul.permispiste.repositories;

import com.epul.permispiste.domains.JeuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JeuRepository extends JpaRepository<JeuEntity, Integer> {
}
