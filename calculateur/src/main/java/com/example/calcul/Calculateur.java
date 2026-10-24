package com.example.calcul;

/**
 * Calculateur simple proposant des opérations.
 */
public class Calculateur implements ICalcul {

    public double additionner(double a, double b) {
        return a + b;
    }

    public double soustraire(double a, double b) {
        return a - b;
    }

    public double multiplier(double a, double b) {
        return a * b;
    }

    public double diviser(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division par zéro impossible");
        }
        return a / b;
    }

    /**
     * Applique l'opérateur donné (+, -, *, /) aux deux opérandes.
     */
    public double calculer(double a, char operateur, double b) {
        return switch (operateur) {
            case '+' -> additionner(a, b);
            case '-' -> soustraire(a, b);
            case '*', 'x' -> multiplier(a, b);
            case '/' -> diviser(a, b);
            default -> throw new IllegalArgumentException("Opérateur inconnu : " + operateur);
        };
    }
}
