package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.LogiParam;
import com.epul.oeuvre.domains.UtilisateurEntity;
import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.oeuvre.repositories.UtilisateurRepository;
import com.epul.oeuvre.utilitaires.MonMotPassHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationService implements IAuthentificationService {

    private UtilisateurRepository unUtilisateurRepostory;

    @Autowired
    public AuthentificationService(UtilisateurRepository UtilisateurRepostory) {
        this.unUtilisateurRepostory = UtilisateurRepostory;
    }

    @Override
    public UtilisateurEntity authentification(LogiParam unUti) throws Exception {
        UtilisateurEntity unUtilisateur = null;
        String message;
        String login = unUti.getNomUtil();
        String pwd = unUti.getMotPasse();
        unUtilisateur = unUtilisateurRepostory.rechercheNom(unUti.getNomUtil());
        if (unUtilisateur != null) {
            try {
                // on récupère le sel
                String sel = unUtilisateur.getSalt();
                // on récupère le mot de passe
                String mdp = unUtilisateur.getMotPasse();
                // on génère le mot de passe avec les données de connexion
                byte[] salt = MonMotPassHash.transformeEnBytes(unUtilisateur.getSalt());
                char[] pwd_char = MonMotPassHash.converttoCharArray(pwd);
                byte[] monpwdCo = MonMotPassHash.generatePasswordHash(pwd_char, salt);
                // on récupère le mot de passe enregistré
                byte[] mdp_byte = MonMotPassHash.transformeEnBytes(mdp);
                if (!MonMotPassHash.verifyPassword(monpwdCo, mdp_byte)) {
                    message = "mot de passe erroné";
                    return null;
                }
            } catch (MonException e) {
                throw e;
            } catch (Exception e) {
                throw e;
            }
        }
        return unUtilisateur;
    }
}
