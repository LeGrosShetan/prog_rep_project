package com.epul.permispiste.controller;

import com.epul.permispiste.mesExceptions.MonException;
import com.epul.permispiste.domains.ActionEntity;
import com.epul.permispiste.domains.ObjectifEntity;
import com.epul.permispiste.domains.RegleEntity;
import com.epul.permispiste.service.ActionService;
import com.epul.permispiste.service.RegleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

@RequestMapping("/regles")
@RestController
@CrossOrigin
public class ControllerRegles {
    @Autowired
    private RegleService uneRegleService;

    @Autowired
    private ActionService uneActionService;

    @RequestMapping(method = RequestMethod.GET, value = "/getRegles")
    public ModelAndView getRegles(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage = "";
        Set<RegleEntity> mesRegles = null;
        try {
            mesRegles = uneRegleService.getToutesLesRegles();
            request.setAttribute("mesRegles", mesRegles);
            destinationPage = "vues/listerRegles";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/vues/Erreur";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "vues/Erreur";
        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "/getRegles/{numAction}\"", method = RequestMethod.GET)
    public ModelAndView getReglesByAction(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "numAction") int numAction) {
        Set<RegleEntity> mesRegles = null;
        ActionEntity monAction = null;
        String destinationPage = "";
        try {
            monAction = uneActionService.getUneActionNum(numAction);
            mesRegles = monAction.getRegles();
            request.setAttribute("mesRegles", mesRegles);
            destinationPage = "vues/listerRegles";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/vues/Erreur";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "vues/Erreur";
        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "/getUneRegle/{numRegle}\"", method = RequestMethod.GET)
    public RegleEntity getRegleByNum(@PathVariable(value = "numRegle") int numRegle) {
        RegleEntity uneRegle = null;
        try {
            uneRegle = uneRegleService.getUneRegleNum(numRegle);
        } catch (MonException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return uneRegle;
    }
}
