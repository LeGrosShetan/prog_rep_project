package com.epul.permispiste.service;

import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.permispiste.domains.ApprenantEntity;
import com.epul.permispiste.repositories.ApprenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ApprenantService implements IApprenantService{

    @Autowired
    private ApprenantRepository unApprenantRepository;

    /**
     * Fonction d'ajout d'un apprenant.
     * @param apprenant L'apprenant à ajouter.
     */
    public void ajouterApprenant(ApprenantEntity apprenant){
        try {
            unApprenantRepository.save(apprenant);
        } catch (Exception e) {
            throw new MonException("Insert", "Sql", e.getMessage());
        }
    }

    /**
     * Fonction de modification d'un apprenant.
     * @param numApprenant L'id de l'apprenant à modifier.
     */
    public void modifierApprenant(int numApprenant){
        try {
            ApprenantEntity unApprenant = new ApprenantEntity();
            ApprenantEntity finalUnApprenant = unApprenant;
            unApprenant = unApprenantRepository.findById(numApprenant).orElseThrow(
                    () -> new MonException("Apprenant", "numApprenant", finalUnApprenant.getNumapprenant())
            );
            unApprenant.setNumapprenant(unApprenant.getNumapprenant());
            unApprenant.setNomapprenant(unApprenant.getNomapprenant());
            unApprenant.setPrenomapprenant(unApprenant.getPrenomapprenant());
            this.unApprenantRepository.save(unApprenant);
        } catch (Exception e) {
            throw new MonException("Insert", "Sql", e.getMessage());
        }
    }

    /**
     * Tri tous les apprenants par ordre alphabétique.
     * @return Une liste triée de tous les apprenants.
     */
    private Sort sortByNom() {
        return new Sort(Sort.Direction.ASC, "nomApprenant");
    }

    /**
     * Liste tous les apprenants.
     * @return La liste de tous les apprenants.
     */
    public Set<ApprenantEntity> getTousLesApprenants() {

        List<ApprenantEntity> mesApprenants = null;
        try {

            mesApprenants = unApprenantRepository.findAll(sortByNom());
        } catch (Exception e) {
            throw new MonException("Insert", "Sql", e.getMessage());
        }
        return (Set<ApprenantEntity>) mesApprenants;
    }

    /**
     * Cherche un apprenant par son numéro d'apprenant.
     * @param numApprenant Le numéro de l'apprenant.
     * @return L'apprenant correspondant au numApprenant.
     */
    public ApprenantEntity getUnApprenantNum(int numApprenant) {
        return unApprenantRepository.findById(numApprenant).orElseThrow(
                () -> new MonException("Client", "numApprenant", numApprenant)
        );
    }
}
