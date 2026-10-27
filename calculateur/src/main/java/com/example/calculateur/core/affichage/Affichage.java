package com.example.calculateur.core.affichage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.calculateur.core.action.ActionType;
import com.example.calculateur.core.commun.erreur.CommunException;
import static com.example.calculateur.core.commun.erreur.ErrorType.*;

import java.util.Arrays;

public class Affichage implements IAffichage {
    private static final Logger log = LoggerFactory.getLogger(Affichage.class);

    @Override
    public void commencer() {
        log.info("=== Calculateur ===");
        log.info("Saisissez une opération (ex : 3 + 4), ou 'q' pour quitter ou 'r' "
                + "pour reutilisé le resultat dans un calcul.");
        log.info("choisir l'operande parmis : '+', '-', 'x,', '/'");
    }

    @Override
    public void terminer() {
        log.info("Fin du calcul ! Fin du programme !");
    }

    @Override
    public void afficher(String texte) {
        log.info(texte);
    }

    
    @Override
    public ActionType verifierActionUser(String ligne) {
        //Vérifier le caractère d'annulation.
        switch (ligne.toLowerCase()) {
            case "q":
                return ActionType.QUITTER;
            case "s", "r":
                return ActionType.RE_CALCULER;
            default:
                return ActionType.CALCULER;
        }
    }

    @Override
    public boolean verifierFormatOk(String ligne) throws CommunException {
        try {
            String[] parties = ligne.split("\\s+");

            if (parties.length == 3) {
                return true;
            } else if (parties.length == 2) {
                return true;
            } else {
                throw new IllegalArgumentException("Format incorrect : " + ligne);
            }
        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            throw new CommunException(FORMAT_ERROR, e);
        }
    }
}
