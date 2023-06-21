package com.epul.oeuvre.controller;


import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.oeuvre.service.EmpruntService;
import com.epul.oeuvre.service.OeuvreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/emprunt")
@RestController
@CrossOrigin
public class ControllerEmprunt {

    @Autowired
    private EmpruntService unEmpruntService;

    private HttpSession session;

/*************************************************/
/**************Tous les emprunts  ******************/
    /*************************************************/
    @RequestMapping(method = RequestMethod.GET, value = "/listerEmprunts")
    public ModelAndView getEmprunts(HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {

        String destinationPage;
        try {
            session = request.getSession();
            if (session.getAttribute("id").equals(null)) {

                String message = "Vous n'êtes pas connecté !!";
                request.setAttribute("message", message);
                destinationPage = "/vues/formLogin";
            }
            else
            {
                request.setAttribute("mesEmprunts", unEmpruntService.consulterTouslesEmprunts());
                destinationPage = "/vues/listerEmprunt";
            }
        } catch (MonException e) {
            // TODO Auto-generated catch block
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/vues/Erreur";
        }

        // Redirection vers la page jsp appropriee
        return new ModelAndView(destinationPage);
    }
}
