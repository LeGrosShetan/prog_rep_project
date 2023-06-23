package com.epul.permispiste.controller;

import com.epul.permispiste.mesExceptions.MonException;
import com.epul.permispiste.domains.ApprenantEntity;
import com.epul.permispiste.domains.InscritEntity;
import com.epul.permispiste.domains.JeuEntity;
import com.epul.permispiste.service.JeuService;
import com.epul.permispiste.service.ApprenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashSet;
import java.util.Set;

@RequestMapping("/jeu")
@RestController
@CrossOrigin
public class ControllerJeu {

    @Autowired
    private JeuService unJeuService;

    @Autowired
    private ApprenantService unApprenantService;

    /**
     * Liste tous les jeux et renvoie à la vue de liste des jeux.
     * @param request
     * @param response
     * @return Un appel à la vue qui liste les jeux.
     * @throws Exception La potentielle exception levée.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/getJeux")
    public ModelAndView getJeux(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage = "";
        Set<JeuEntity> mesJeux = null;
        try {
            mesJeux = unJeuService.getTousLesJeux();
            request.setAttribute("mesJeux", mesJeux);
            destinationPage = "vues/listerJeux";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/vues/Erreur";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "vues/Erreur";
        }
        return new ModelAndView(destinationPage);
    }

    /**
     * Récupère une liste de tous les jeux auquel est inscrit l'apprenant de numéro numApprenant.
     * @param numApprenant Le numéro de l'apprenant dont on cherche les jeux.
     * @return L'action correspondant au numéro d'action.
     */
    @RequestMapping(value = "/getJeux/{numApprenant}\"", method = RequestMethod.GET)
    public ModelAndView getJeuxByApprenant(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "numApprenant") int numApprenant) {
        Set<JeuEntity> mesJeux = new HashSet<>();
        ApprenantEntity monApprenant = null;
        String destinationPage = "";
        try {
            monApprenant = unApprenantService.getUnApprenantNum(numApprenant);
            Set<InscritEntity> mesInscriptions = monApprenant.getInscriptions();

            for (InscritEntity inscrit : mesInscriptions){
                mesJeux.add(inscrit.getJeu());
            }

            request.setAttribute("mesJeux", mesJeux);
            destinationPage = "vues/listerJeux";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/vues/Erreur";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "vues/Erreur";
        }
        return new ModelAndView(destinationPage);
    }

    /**
     * Récupère un jeu via son numéro de jeu.
     * @param numJeu Le numéro du jeu à chercher.
     * @return Le jeu correspondant au numéro de jeu.
     */
    @RequestMapping(value = "/getUnJeu/{numJeu}\"", method = RequestMethod.GET)
    public JeuEntity getJeuByNum(@PathVariable(value = "numJeu") int numJeu) {
        JeuEntity unJeu = null;
        try {
            unJeu = unJeuService.getUnJeuNum(numJeu);
        } catch (MonException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return unJeu;
    }
}
