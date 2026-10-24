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

    
    //TODO : Faire une vérification de l'annulation et de la sauveguarde
    @Override
    public boolean verifierCaratereOk(String ligne) {
        if (ligne.equalsIgnoreCase("q")) {
            return true;
        }
        return true;
    }
    
    /**
     * TODO : Faire appel a la vérification de l'annulation et de la sauveguarde
     * pour la taiche de la chaines composant le carac  = 4, evaluer le 4 ème caractère
     * */
    @Override
    public boolean verifierFormatOk(String ligne) {
        String[] parties = ligne.split("\\s+");
        if (parties.length != 3 || parties.length != 4) {
            System.out.println("Format attendu : <nombre> <opérateur> <nombre>");
            return false;
        }    
        return true;
    }

}
