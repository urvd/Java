package com.example.calculateur;

import java.util.Scanner;

import com.example.calculateur.core.affichage.Affichage;
import com.example.calculateur.core.affichage.IAffichage;
import com.example.calculateur.core.calcul.Calculateur;
import com.example.calculateur.core.calcul.ICalcul;
import com.example.calculateur.core.calcul.OperateurType;
import com.example.calculateur.core.calcul.Operation;
import com.example.calculateur.core.commun.FormatUtils;
import com.example.calculateur.core.commun.erreur.CommunException;
import com.example.calculateur.core.commun.erreur.ErrorType;

/**
 * Point d'entrée : calculateur interactif en ligne de commande.
 */
public class App {

    public static void main(String[] args) {
        ICalcul calculateur = new Calculateur();
        IAffichage affichage = new Affichage();
        boolean sauvegarde = false;
        boolean annulation = false;

        Scanner scanner = new Scanner(System.in);

        affichage.commencer();

        while (sauvegarde == false || annulation  == false) {
            try {
                 affichage.afficher("Saisir > ");
                if (!scanner.hasNextLine()) {
                    break;
                }      
            
                String ligne = scanner.nextLine().trim() ;
                affichage.afficher("Calcul : " + ligne);
                annulation = affichage.verifierAnnulation(ligne);
                if(annulation) break;                
                if (!affichage.verifierFormatOk(ligne)) {
                    continue;
                }
                String[] parties = ligne.split("\\s+");
                Operation operation = new Operation(FormatUtils.convertirEnNombre(parties[0]), 
                    FormatUtils.convertirEnNombre(parties[2]),
                    OperateurType
                        .rechercheOperateur(String.valueOf(parties[1].charAt(0))));

                double resultat = calculateur.calculer(operation);

                affichage.afficher("Resultat =  {" + resultat + "}");
        
            } catch (CommunException e) {
                affichage.afficher(e.getErrorType().getMessage());
            }
        }       
        scanner.close();
        affichage.terminer();
    }
}
