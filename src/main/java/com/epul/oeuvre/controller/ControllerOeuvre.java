package com.epul.oeuvre.controller;


import com.epul.oeuvre.domains.OeuvreventeEntity;
import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.oeuvre.service.OeuvreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RequestMapping("/oeuvres")
@RestController
@CrossOrigin
public class ControllerOeuvre {

    @Autowired
    private OeuvreService unOeuvreService;



/*************************************************/
/**************Toutes les oeuvres  ******************/
    /*************************************************/
    @RequestMapping(method = RequestMethod.GET, value = "/getOeuvres")
    public ModelAndView getOeuvres(HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {

        String destinationPage = "";
        List<OeuvreventeEntity> mesOeuvres = null;
        try {
            mesOeuvres = unOeuvreService.getToutesLesOeuvres();
            request.setAttribute("mesOeuvres", mesOeuvres);
            destinationPage = "vues/listerOeuvre";
        }  catch (MonException e) {
                request.setAttribute("MesErreurs", e.getMessage());
                destinationPage = "/vues/Erreur";
            }
         catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "vues/Erreur";
        }
        return new ModelAndView(destinationPage);
    }



    @GetMapping("/getUneOeuvre/{id}")
    public OeuvreventeEntity getOeuvreById(@PathVariable(value = "id") int id) {
        OeuvreventeEntity uneOV = null;
        try {
            uneOV = unOeuvreService.getUneOeuvreID(id);
        } catch (MonException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return uneOV;
    }


    @RequestMapping(method = RequestMethod.POST, value = "/insererOeuvre")
    public ModelAndView insererOeuvre(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        String destinationPage = "";
        try {
            OeuvreventeEntity uneOeuvre = new OeuvreventeEntity();
            uneOeuvre.setTitreOeuvrevente(request.getParameter("txtnom"));
            uneOeuvre.setEtatOeuvrevente(request.getParameter("txtetat"));
            uneOeuvre.setPrixOeuvrevente(Double.parseDouble(request.getParameter("numberprix")));
            uneOeuvre.setIdProprietaire(Integer.parseInt(request.getParameter("numberproprio")));
            this.unOeuvreService.inserer(uneOeuvre);
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/vues/Erreur";
        }
        destinationPage = "index";
        return new ModelAndView(destinationPage);
    }



}

