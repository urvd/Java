package com.example.core.calcul;

import com.example.core.commun.erreur.CommunException;

/**
 * Calculateur simple proposant des opérations.
 */
public class Calculateur implements ICalcul {

    private double additionner(double a, double b) {
        return a + b;
    }

    private double soustraire(double a, double b) {
        return a - b;
    }

    private double multiplier(double a, double b) {
        return a * b;
    }

    public double diviser(double a, double b) throws CommunException {
        if (b == 0) {
            throw new ArithmeticException("Division par zéro impossible");
        }
        return a / b;
    }

    /**
     * Applique l'opérateur donné (+, -, * ou x, /) aux deux opérandes.
     */
    public double calculer(double a, char operateur, double b) throws CommunException {
        try {    
            return switch (operateur) {
                case '+' -> additionner(a, b);
                case '-' -> soustraire(a, b);
                case '*', 'x' -> multiplier(a, b);
                case '/' -> diviser(a, b);
                default -> throw new IllegalArgumentException("Opérateur inconnu : " + operateur);
            };
        } catch (ArithmeticException | IllegalArgumentException e) {
            throw new CommunException("Erreur de calcul ou calcul invalide", e);
        }
    }
}
