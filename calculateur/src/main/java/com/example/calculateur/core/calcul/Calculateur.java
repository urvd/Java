package com.example.calculateur.core.calcul;

import com.example.calculateur.core.commun.erreur.CommunException;

import static com.example.calculateur.core.commun.erreur.ErrorType.*;
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

    private double diviser(double a, double b) throws CommunException {
        if (b == 0) {
            throw new ArithmeticException("Division par zéro impossible");
        }
        return a / b;
    }

    /**
     * Applique l'opérateur donné (+, -, * ou x, /) aux deux opérandes.
     */
    public double calculer(Operation operation) throws CommunException {
        try {    
            return switch (operation.operateur()) {
                case ADDITION -> additionner(operation.operande1(), operation.operande2());
                case SOUSTRACTION -> soustraire(operation.operande1(), operation.operande2());
                case MULTIPLICATION, MULTIPLICATION_X -> multiplier(operation.operande1(), operation.operande2());
                case DIVISION -> diviser(operation.operande1(), operation.operande2());
                default -> throw new IllegalArgumentException("Opérateur inconnu : " + operation.operateur().getSymbole());
            };
        } catch (ArithmeticException | IllegalArgumentException e) {
            if(e instanceof ArithmeticException) {
                throw new CommunException(ARITHMETIC_ERROR, e);
            } else if (e instanceof IllegalArgumentException) {
                throw new CommunException(ILLEGAL_ARGUMENT_ERROR, e);
            }
            throw new CommunException(UNDEFINED_ERROR, e);
        }
    }
}
