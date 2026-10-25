package com.example.calculateur.core.affichage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.calculateur.core.commun.erreur.CommunException;
import static com.example.calculateur.core.commun.erreur.ErrorType.*;

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
    public boolean verifierFormatOk(String ligne) throws CommunException {
        try {
            String[] parties = ligne.split("\\s+");
            if (parties.length != 3) {
                throw new IllegalArgumentException("Format incorrect : " + ligne);
            }
            return parties.length == 3;
        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            if (e instanceof IllegalArgumentException) {
                throw new CommunException(FORMAT_ERROR, e);
            } else if (e instanceof ArrayIndexOutOfBoundsException) {
                throw new CommunException(ARRAY_INDEX_OUT_OF_BOUNDS_ERROR, e);
            }else {
                throw new CommunException(UNDEFINED_ERROR, e);
            }
        }
    }
}
