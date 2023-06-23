package com.epul.permispiste.controller;

import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.permispiste.domains.MissionEntity;
import com.epul.permispiste.domains.InscritEntity;
import com.epul.permispiste.domains.JeuEntity;
import com.epul.permispiste.service.MissionService;
import com.epul.permispiste.service.JeuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.Set;

@RequestMapping("/mission")
@RestController
@CrossOrigin
public class ControllerMission {

    @Autowired
    private MissionService uneMissionService;

    /**
     * Liste tous les jeux et renvoie à la vue de liste des jeux.
     * @param request
     * @param response
     * @return Un appel à la vue qui liste les jeux.
     * @throws Exception La potentielle exception levée.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/getMissions")
    public ModelAndView getMissions(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage = "";
        Set<MissionEntity> mesMissions = null;
        try {
            mesMissions = uneMissionService.getToutesLesMissions();
            request.setAttribute("mesMissions", mesMissions);
            destinationPage = "vues/listerMissions";
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
     * @param numJeu Le numéro de l'apprenant dont on cherche les jeux.
     * @return L'action correspondant au numéro d'action.
     */
    @RequestMapping(value = "/getMissions/{numJeu}\"", method = RequestMethod.GET)
    public ModelAndView getMissionsByJeu(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "numJeu") int numJeu) {
        Set<MissionEntity> mesMissions = null;
        JeuEntity monJeu = null;
        String destinationPage = "";
        try {
            mesMissions = monJeu.getMissions();
            request.setAttribute("mesMissions", mesMissions);
            destinationPage = "vues/listerMissions";
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
     * @param numMission Le numéro du jeu à chercher.
     * @return Le jeu correspondant au numéro de jeu.
     */
    @RequestMapping(value = "/getUneMission/{numMission}\"", method = RequestMethod.GET)
    public MissionEntity getMissionByNum(@PathVariable(value = "numMission") int numMission) {
        MissionEntity uneMission = null;
        try {
            uneMission = uneMissionService.getUneMissionNum(numMission);
        } catch (MonException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return uneMission;
    }
}
