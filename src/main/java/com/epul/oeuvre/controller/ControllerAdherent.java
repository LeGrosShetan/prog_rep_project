package com.epul.oeuvre.controller;

import com.epul.oeuvre.domains.AdherentEntity;
import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.oeuvre.service.AdherentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RequestMapping("/adherent")
@RestController
@CrossOrigin
public class ControllerAdherent {

    @Autowired
    private AdherentService unAdherentService;

/*************************************************/
/**************Tous les adhérents  ******************/
    /*************************************************/
    @RequestMapping(method = RequestMethod.GET, value = "/getAdherents")
    public ModelAndView getAdherents(HttpServletRequest request,
                                     HttpServletResponse response) throws Exception {

        String destinationPage = "";
        List<AdherentEntity> mesAdherents = null;
        try {
            mesAdherents = unAdherentService.getTousLesAdherents();
            request.setAttribute("mesAdherents", mesAdherents);
            destinationPage = "vues/listerAdherent";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/vues/Erreur";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "vues/Erreur";
        }
        return new ModelAndView(destinationPage);
    }

   /* private Sort sortByNom() {
        return new Sort(Sort.Direction.ASC, "nomAdherent");
    }*/

    @RequestMapping(value = "/getUnAdherent/{id}\"", method = RequestMethod.GET)
    public AdherentEntity getAdherentById(@PathVariable(value = "id") int id) {
        AdherentEntity unAd = null;
        try {
            unAd = unAdherentService.getUnAdherentID(id);
        } catch (MonException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return unAd;
    }


    @RequestMapping(method = RequestMethod.POST, value = "/insererAdherent")
    public ModelAndView insererAdherent(HttpServletRequest request,
                                        HttpServletResponse response) throws Exception {

        String destinationPage = "";
        try {
            AdherentEntity unAdherent = new AdherentEntity();
            unAdherent.setNomAdherent(request.getParameter("txtnom"));
            unAdherent.setPrenomAdherent(request.getParameter("txtprenom"));
            unAdherent.setVilleAdherent(request.getParameter("txtville"));
            unAdherentService.ajouterClient(unAdherent);
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


    @RequestMapping(value = "/ajout")
    public ModelAndView ajouterAdherent(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String destinationPage = "";
        try {
            destinationPage = "vues/ajouterAdherent";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/vues/Erreur";
        }

        return new ModelAndView(destinationPage);
    }
}

