package com.epul.permispiste.repositories;

import com.epul.permispiste.domains.IndicateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndicateurRepository extends JpaRepository<IndicateurEntity, Integer> {
}