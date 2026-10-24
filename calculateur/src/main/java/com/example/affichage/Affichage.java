package com.example.affichage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Affichage implements IAffichage {
    private static final Logger log = LoggerFactory.getLogger(Affichage.class);
    @Override
    public void commencer() {
        log.info("=== Calculateur ===");
        log.info("Saisissez une opération (ex : 3 + 4), ou 'q' pour quitter.");
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
    //TODO : mieux gérer les exeption, les centralisé si possible
    @Override
    public void afficherErreur(String texte, String msgErr) {
        log.info(texte);
        //log.error(msgErr);
        log.info(msgErr);
    }

    
    @Override
    public boolean verifierAnnulation(String ligne) {
        //Vérifier le caractère d'annulation.
        if (ligne.equalsIgnoreCase("q")) {
            return true;
        }
        return false;
    }

    /**
     * TODO : Faire une vérification de la sauveguarde
     * verifierSauvegarde(String ligne)
     * /
    
    /**
     * TODO : Faire appel que si l'annulation et de la sauveguarde
     * pour la taiche de la chaines composant le carac  = 4, evaluer le 4 ème caractère
     * */
    @Override
    public boolean verifierFormatOk(String ligne) {
        String[] parties = ligne.split("\\s+");
        if (parties.length != 3 || parties.length != 2 || parties.length != 1) {
            afficher("Format attendu : <nombre> <opérateur> <nombre>");
            return false;
        }    
        return true;
    }

}
