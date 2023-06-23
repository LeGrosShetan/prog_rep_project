package com.epul.permispiste.controller;

import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.permispiste.domains.ApprenantEntity;
import com.epul.permispiste.domains.MissionEntity;
import com.epul.permispiste.domains.JeuEntity;
import com.epul.permispiste.domains.ObjectifEntity;
import com.epul.permispiste.service.MissionService;
import com.epul.permispiste.service.ObjectifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.Set;

@RequestMapping("/objectif")
@RestController
@CrossOrigin
public class ControllerObjectif {

    @Autowired
    private ObjectifService unObjectifService;

    @Autowired
    private MissionService uneMissionService;

    /**
     * Liste tous les jeux et renvoie à la vue de liste des jeux.
     * @param request
     * @param response
     * @return Un appel à la vue qui liste les jeux.
     * @throws Exception La potentielle exception levée.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/getObjectifs")
    public ModelAndView getObjectifs(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage = "";
        Set<ObjectifEntity> mesObjectifs = null;
        try {
            mesObjectifs = unObjectifService.getTousLesObjectifs();
            request.setAttribute("mesObjectifs", mesObjectifs);
            destinationPage = "vues/listerObjectifs";
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
     * @param numMission Le numéro de l'apprenant dont on cherche les jeux.
     * @return L'action correspondant au numéro d'action.
     */
    @RequestMapping(value = "/getObjectifs/{numMission}\"", method = RequestMethod.GET)
    public ModelAndView getObjectifsByMission(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "numMission") int numMission) {
        Set<ObjectifEntity> mesObjectifs = null;
        MissionEntity maMission = null;
        String destinationPage = "";
        try {
            maMission = uneMissionService.getUneMissionNum(numMission);
            mesObjectifs = maMission.getObjectifs();
            request.setAttribute("mesObjectifs", mesObjectifs);
            destinationPage = "vues/listerObjectifs";
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
     * @param numObjectif Le numéro du jeu à chercher.
     * @return Le jeu correspondant au numéro de jeu.
     */
    @RequestMapping(value = "/getUnObjectif/{numObjectif}\"", method = RequestMethod.GET)
    public ObjectifEntity getObjectifByNum(@PathVariable(value = "numObjectif") int numObjectif) {
        ObjectifEntity unObjectif = null;
        try {
            unObjectif = unObjectifService.getUnObjectifNum(numObjectif);
        } catch (MonException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return unObjectif;
    }
}
