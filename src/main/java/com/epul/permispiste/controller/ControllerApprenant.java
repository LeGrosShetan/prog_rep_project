package com.epul.permispiste.controller;

import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.permispiste.domains.ApprenantEntity;
import com.epul.permispiste.service.ApprenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequestMapping("/apprenant")
@RestController
@CrossOrigin
public class ControllerApprenant {

    @Autowired
    private ApprenantService unApprenantService;

    /**
     * Liste tous les apprenants et renvoie à la vue de liste des apprenants.
     * @param request
     * @param response
     * @return Un appel à la vue qui liste les apprenants.
     * @throws Exception La potentielle exception levée.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/getApprenants")
    public ModelAndView getApprenants(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage = "";
        List<ApprenantEntity> mesApprenants = null;
        try {
            mesApprenants = unApprenantService.getTousLesApprenants();
            request.setAttribute("mesApprenants", mesApprenants);
            destinationPage = "vues/listerApprenants";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "vues/Erreur";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "vues/Erreur";
        }
        return new ModelAndView(destinationPage);
    }

    /**
     * Récupère un apprenant via son numéro d'apprenant.
     * @param numApprenant Le numéro de l'apprenant à chercher.
     * @return L'apprenant correspondant au numéro d'apprenant.
     */
    @RequestMapping(value = "/getUnApprenant/{numApprenant}\"", method = RequestMethod.GET)
    public ApprenantEntity getApprenantByNum(@PathVariable(value = "numApprenant") int numApprenant) {
        ApprenantEntity unApprenant = null;
        try {
            unApprenant = unApprenantService.getUnApprenantNum(numApprenant);
        } catch (MonException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return unApprenant;
    }

    /**
     * Insert un apprenant et renvoie à la vue index.
     * @param request
     * @param response
     * @return Appel à la vue index.
     * @throws Exception La potentielle exception levée.
     */
    @RequestMapping(method = RequestMethod.POST, value = "/insererApprenant")
    public ModelAndView insererApprenant(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage = "";
        try {
            ApprenantEntity unApprenant = new ApprenantEntity();
            unApprenant.setNomapprenant(request.getParameter("nomApprenant"));
            unApprenant.setPrenomapprenant(request.getParameter("prenomApprenant"));
            unApprenantService.ajouterApprenant(unApprenant);
            destinationPage = "index";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/vues/Erreur";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/vues/Erreur";
        }

        return new ModelAndView(destinationPage);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/modifierApprenant/{numApprenant}\"")
    public ModelAndView modifierApprenant(HttpServletRequest request, @PathVariable(value = "numApprenant") int numApprenant) throws Exception {
        String destinationPage = "";
        Set<ApprenantEntity> mesApprenants = null;
        try {
            unApprenantService.modifierApprenant(numApprenant);
            mesApprenants = unApprenantService.getTousLesApprenants();
            request.setAttribute("mesApprenants", mesApprenants);
            destinationPage = "vues/listerApprenants";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/vues/Erreur";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/vues/Erreur";
        }

        return new ModelAndView(destinationPage);
    }

    /**
     * Renvoie vers la vue d'ajout d'un apprenant.
     * @param request
     * @param response
     * @return Appel à la vue d'ajout d'un apprenant.
     * @throws Exception La potentielle exception levée.
     */
    @RequestMapping(value = "/ajoutApprenant")
    public ModelAndView ajouterApprenant(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage = "";
        try {
            destinationPage = "vues/ajouterApprenant";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/vues/Erreur";
        }

        return new ModelAndView(destinationPage);
    }
}
