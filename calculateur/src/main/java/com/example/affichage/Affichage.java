package com.example.affichage;
import java.util.Arrays;

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
    //TODO : mieux gérer les exception, les centralisés si possible
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
     * Vérification du Format : en 3 entité séparé
     * TODO : Format: 1 - A Faire évoluer en suite ou liste d'entités séparé
     * TODO : Format: 2 - A Faire évoluer pour admetre 1 seul entité mais pas e
     * exclure 2 entités.
     * */
    @Override
    public boolean verifierFormatOk(String ligne) {
        try{
            String[] parties = ligne.split("\\s+");
            afficher(ligne);
            afficher(Arrays.toString(parties));
            if (parties.length != 3) {
                afficher("Format attendu : <nombre> <opérateur> <nombre>");
                return false;
            }    
            return true;
        }catch(ArrayIndexOutOfBoundsException e){
            afficherErreur("Erreur de saisie !", e.getMessage());
            return false;
        }
       
      
    }

}
