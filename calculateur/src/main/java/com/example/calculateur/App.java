package com.example.calculateur;

import java.util.Scanner;

import com.example.core.affichage.Affichage;
import com.example.core.affichage.IAffichage;
import com.example.core.calcul.Calculateur;
import com.example.core.calcul.ICalcul;
import com.example.core.commun.erreur.CommunException;

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
            affichage.afficher("> ");
            if (!scanner.hasNextLine()) {
                break;
            }
            String ligne = scanner.nextLine().trim() ;
            affichage.afficher(ligne);
            annulation = affichage.verifierAnnulation(ligne);
            if(annulation) break;
            
           
            try {
                String[] parties = ligne.split("\\s+");
                if (affichage.verifierFormatOk(ligne)) {
                    continue;
                }
                double a = convertirEnNombre(parties[0]);
                double b = convertirEnNombre(parties[2]);
                double resultat = calculateur.calculer(a, parties[1].charAt(0), b);
                affichage.afficher("=  {" +resultat +"}");
        
            } catch (CommunException e) {
                //affichage.afficherErreur("Erreur de calcul : " + e.getMessage(), e.getMessage());
            }/*  catch (NumberFormatException e) {
                //affichage.afficherErreur("Erreur de format : " + e.getMessage(), e.getMessage());
            } catch (ArithmeticException e) {
                //affichage.afficherErreur("Erreur arithmétique : " + e.getMessage(), e.getMessage());
            } catch (IllegalArgumentException e) {
                //affichage.afficherErreur("Opérateur inconnu : " + e.getMessage(), e.getMessage());
            } catch (Exception e) {
               //ffichage.afficherErreur("Erreur inattendue : " + e.getMessage(), e.getMessage());
            }*/
        }       
        scanner.close();
        affichage.terminer();
    }

    private static double convertirEnNombre(String texte) throws CommunException {
    try {
        return Double.parseDouble(texte);
    } catch (NumberFormatException e) {
        throw new CommunException("Nombre invalide", e);
    }
}
}
