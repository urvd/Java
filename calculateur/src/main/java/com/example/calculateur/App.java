package com.example.calculateur;

import java.util.Scanner;

/**
 * Point d'entrée : calculateur interactif en ligne de commande.
 */
public class App {

    public static void main(String[] args) {
        Calculateur calculateur = new Calculateur();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Calculateur ===");
        System.out.println("Saisissez une opération (ex : 3 + 4), ou 'q' pour quitter.");

        while (true) {
            System.out.print("> ");
            if (!scanner.hasNextLine()) {
                break;
            }
            String ligne = scanner.nextLine().trim();
            if (ligne.equalsIgnoreCase("q")) {
                break;
            }
            String[] parties = ligne.split("\\s+");
            if (parties.length != 3 || parties[1].length() != 1) {
                System.out.println("Format attendu : <nombre> <opérateur> <nombre>");
                continue;
            }
            try {
                double a = Double.parseDouble(parties[0]);
                double b = Double.parseDouble(parties[2]);
                double resultat = calculateur.calculer(a, parties[1].charAt(0), b);
                System.out.println("= " + resultat);
            } catch (NumberFormatException e) {
                System.out.println("Nombre invalide.");
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }
        System.out.println("Au revoir !");
    }
}
