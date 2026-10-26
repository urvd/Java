package com.example.calculateur;

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
import com.example.calculateur.core.resultat.Resultat;

/**
 * Point d'entrée : calculateur interactif en ligne de commande.
 */
public class App {

    public static void main(String[] args) {
        ICalcul calculateur = new Calculateur();
        IAffichage affichage = new Affichage();
        ActionType currentAction = ActionType.INITIALISATION;
        Resultat resultat0 = new Resultat(0.0, false);
        Resultat resultatActual = new Resultat(0.0, false);

        Scanner scanner = new Scanner(System.in);

        affichage.commencer();

        while (currentAction != ActionType.QUITTER) {
            try {
                 affichage.afficher("Saisir > ");
                if (!scanner.hasNextLine()) {
                    break;
                }      
            
                String ligne = scanner.nextLine().trim() ;

                // Vérification de l'action de l'utilisateur - cas d'annulation ou de recalcul
                currentAction = affichage.verifierActionUser(ligne);
                if(currentAction == ActionType.QUITTER) break;       
                affichage.afficher("INIT : " + resultat0.valeur() + " ACTUAL : " + resultatActual.valeur());
                affichage.afficher("Dernière ACTION est " + currentAction);
                if (currentAction == ActionType.RECALCULER 
                    || !affichage.verifierFormatOk(ligne)) {
                    if (currentAction == ActionType.RECALCULER) currentAction = ActionType.CALCULER;
                    continue;
                }
                // Convertion en operation
                String[] parties = ligne.split("\\s+");
                Operation operation = null;
                if(parties.length == 2 && currentAction == ActionType.CALCULER) {
                    operation = new Operation(resultat0.valeur(), 
                    FormatUtils.convertirEnNombre(parties[1]),
                    OperateurType
                        .rechercheOperateur(String.valueOf(parties[0].charAt(0))));
                } else if (parties.length == 2 && currentAction == ActionType.RECALCULER) {
                    operation = new Operation(resultatActual.valeur(), 
                    FormatUtils.convertirEnNombre(parties[0]),
                    OperateurType
                        .rechercheOperateur(String.valueOf(parties[1].charAt(0))));
                    currentAction = ActionType.CALCULER;
                } else { //
                    operation = new Operation(FormatUtils.convertirEnNombre(parties[0]), 
                    FormatUtils.convertirEnNombre(parties[2]),
                    OperateurType
                        .rechercheOperateur(String.valueOf(parties[1].charAt(0))));
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
}
