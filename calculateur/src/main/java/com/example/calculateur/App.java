package com.example.calculateur;

import java.util.Arrays;
import java.util.Scanner;

import com.example.calculateur.core.action.ActionType;
import com.example.calculateur.core.affichage.Affichage;
import com.example.calculateur.core.affichage.IAffichage;
import com.example.calculateur.core.calcul.Calculateur;
import com.example.calculateur.core.calcul.ICalcul;
import com.example.calculateur.core.calcul.OperateurType;
import com.example.calculateur.core.calcul.Operation;
import com.example.calculateur.core.commun.FormatUtils;
import com.example.calculateur.core.commun.erreur.CommunException;
import com.example.calculateur.core.commun.erreur.ErrorType;
import com.example.calculateur.core.resultat.Resultat;

/**
 * Point d'entrée : calculateur interactif en ligne de commande.
 */
public class App {

    public static void main(String[] args) {
        ICalcul calculateur = new Calculateur();
        IAffichage affichage = new Affichage();
        ActionType currentAction = ActionType.INITIALISATION;
        Operation operation = new Operation();
        Resultat resultat0 = new Resultat(0.0, false);
        Resultat resultatActual = new Resultat(0.0, false);

        Scanner scanner = new Scanner(System.in);

        affichage.commencer();

        while (currentAction != ActionType.QUITTER) {
            try {
                if (currentAction == ActionType.RE_CALCULER) {
                    affichage.afficher("Saisir (" + resultatActual.valeur() + ") >");
                } else {
                    if (currentAction == ActionType.INITIALISATION) resultatActual = resultat0;
                    affichage.afficher("Saisir > ");
                }


            
                String ligne = scanner.nextLine().trim();
                String[] parties = ligne.split("\\s+");
                //affichage.afficher("INIT : " + resultat0.valeur() + " ACTUAL : " + resultatActual.valeur());
                //affichage.afficher("Dernière ACTION est " + currentAction);
                affichage.afficher(Arrays.toString(parties));
                // Vérification de l'action de l'utilisateur - cas d'annulation ou de recalcul
                currentAction = affichage.verifierActionUser(ligne);
                if(currentAction == ActionType.QUITTER) break;       

                if (currentAction == ActionType.SAUVEGUARDER
                    || !affichage.verifierFormatOk(ligne)) {
                    if (currentAction == ActionType.SAUVEGUARDER) currentAction = ActionType.RE_CALCULER;
                    continue;
                }

                // Convertion en operation
                if (parties.length == 2) {
                    operation = creerOperation(parties, resultatActual.valeur());
                } else {
                    operation = creerOperation(parties);
                }

                // Calcul
                resultatActual = calculateur.calculer(operation);

                affichage.afficher("Resultat =  {" + resultatActual.valeur() + "}");
        
            } catch (CommunException e) {
                affichage.afficher(e.getErrorType().getMessage());
            }
        }       
        scanner.close();
        affichage.terminer();
    }

    private static Operation creerOperation(String[] parties, double exValeur) throws CommunException {
        return new Operation(exValeur,
                    FormatUtils.convertirEnNombre(parties[1]),
                    OperateurType
                            .rechercheOperateur(parties[0]));
    }

    private static Operation creerOperation(String[] parties) throws CommunException {
        return new Operation(FormatUtils.convertirEnNombre(parties[0]),
                    FormatUtils.convertirEnNombre(parties[2]),
                    OperateurType
                            .rechercheOperateur(parties[1]));
    }

}
