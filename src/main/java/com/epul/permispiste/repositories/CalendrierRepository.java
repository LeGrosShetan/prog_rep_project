package com.epul.permispiste.repositories;

import com.epul.permispiste.domains.CalendrierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendrierRepository extends JpaRepository<CalendrierEntity, Integer> {
}