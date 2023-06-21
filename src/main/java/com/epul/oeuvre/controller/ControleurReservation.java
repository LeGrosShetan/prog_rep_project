package com.epul.oeuvre.controller;

import com.epul.oeuvre.service.ServiceReservation;
import com.epul.oeuvre.mesExceptions.MonException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller("/reservation")
public class ControleurReservation {
    @RequestMapping(value = "/reservation/listerReservations.htm")
    public ModelAndView afficherLesReservations(HttpServletRequest request,
                                                HttpServletResponse response) throws Exception{
        String destinationPage;
        try{
            HttpSession session = request.getSession();
            if(session.getAttribute("id").equals(null)){
                String message = "Vous n'êtes pas connecte !";
                request.setAttribute("message", message);
                destinationPage = "/vues/formLogin";
            }
            else{
                ServiceReservation unServiceReservation = new ServiceReservation();
                request.setAttribute("mesReservations", unServiceReservation.consulterReservations());
                destinationPage = "/vues/listerReservation";
            }
        } catch (MonException e){
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/vues/Erreur";
        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "/reservation/listerReservationsDto.htm")
    public ModelAndView afficherLesReservationsDto(HttpServletRequest request,
                                                   HttpServletResponse response) throws Exception{
        String destinationPage;
        try{
            HttpSession session = request.getSession();
            if(session.getAttribute("id").equals(null)){
                String message = "Vous n'êtes pas connecte !";
                request.setAttribute("message", message);
                destinationPage = "/vues/formLogin";
            }
            else{
                ServiceReservation unServiceReservation = new ServiceReservation();
                request.setAttribute("mesReservations", unServiceReservation.consulterListeReservationsDto());
                destinationPage = "/vues/listerReservationDto";
            }
        } catch (MonException e){
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/vues/Erreur";
        }
        return new ModelAndView(destinationPage);
    }
}
