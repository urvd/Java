package com.example.calculateur;

import java.util.Scanner;

import com.example.affichage.Affichage;
import com.example.affichage.IAffichage;
import com.example.calcul.Calculateur;
import com.example.calcul.ICalcul;

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
            String ligne = scanner.nextLine().trim();
            affichage.afficher(ligne);
            annulation = affichage.verifierAnnulation(ligne);
            if(annulation) break;
            
            if (affichage.verifierFormatOk(ligne)) {
                continue;
            }
            try {
                String[] parties = ligne.split("\\s+");
                double a = Double.parseDouble(parties[0]);
                double b = Double.parseDouble(parties[2]);
                double resultat = calculateur.calculer(a, parties[1].charAt(0), b);
                affichage.afficher("=  {" +resultat +"}");
            } catch (NumberFormatException e) {
                affichage.afficherErreur("Saisie invalide !", e.getMessage());
            } catch (ArithmeticException | IllegalArgumentException e) {
                affichage.afficherErreur("Erreur de saisie ! ", e.getMessage());
            }
        }       
        scanner.close();
        affichage.terminer();
    }
}
