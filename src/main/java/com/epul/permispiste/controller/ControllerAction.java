package com.epul.permispiste.controller;

import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.permispiste.domains.ActionEntity;
import com.epul.permispiste.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequestMapping("/action")
@RestController
@CrossOrigin
public class ControllerAction {

    @Autowired
    private ActionService uneActionService;

    @RequestMapping(method = RequestMethod.GET, value = "/getActions")
    public ModelAndView getActions(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage = "";
        List<ActionEntity> mesActions = null;
        try {
            mesActions = uneActionService.getToutesLesActions();
            request.setAttribute("mesActions", mesActions);
            destinationPage = "vues/listerActions";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/vues/Erreur";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "vues/Erreur";
        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "/getUneAction/{numAction}\"", method = RequestMethod.GET)
    public ActionEntity getJeuByNum(@PathVariable(value = "numAction") int numAction) {
        ActionEntity uneAction = null;
        try {
            uneAction = uneActionService.getUneActionNum(numAction);
        } catch (MonException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return uneAction;
    }
}
