package com.example.calculateur.core.calcul;

import com.example.calculateur.core.commun.erreur.CommunException;
import com.example.calculateur.core.resultat.Resultat;

import static com.example.calculateur.core.commun.erreur.ErrorType.*;
/**
 * Calculateur simple proposant des opérations.
 */
public class Calculateur implements ICalcul {

    private Resultat additionner(double a, double b) {
        return new Resultat(a + b, true);
    }

    private Resultat soustraire(double a, double b) {
        return new Resultat(a - b, true);
    }

    private Resultat multiplier(double a, double b) {
        return new Resultat(a * b, true);
    }

    private Resultat diviser(double a, double b) throws CommunException {
        if (b == 0) {
            throw new ArithmeticException("Division par zéro impossible");
        }
        return new Resultat(a / b, true);
    }

    /**
     * Applique l'opérateur donné (+, -, * ou x, /) aux deux opérandes.
     */
    public Resultat calculer(Operation operation) throws CommunException {
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
