package com.epul.oeuvre.repositories;

import com.epul.oeuvre.domains.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<UtilisateurEntity, Integer>  {

    public UtilisateurEntity rechercheNom(String login);

}

