package com.example.calculateur.core.calcul;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.example.calculateur.core.commun.erreur.CommunException;

class CalculateurTest {

    private final ICalcul calculateur = new Calculateur();

    @Test
    void additionner() throws CommunException {
        OperateurType operateur = OperateurType.ADDITION;
        assertEquals(7, calculateur
            .calculer(new Operation(3, 4, operateur)));
    }

    @Test
    void soustraire() throws CommunException {
        OperateurType operateur = OperateurType.SOUSTRACTION;
        assertEquals(-1, 
            calculateur.calculer(new Operation(3, 4, operateur)));
    }

    @Test
    void multiplier() throws CommunException {
        OperateurType operateur = OperateurType.MULTIPLICATION;
        assertEquals(12, 
            calculateur.calculer(new Operation(3, 4, operateur)));
    }

    @Test
    void diviser() throws CommunException {
        OperateurType operateur = OperateurType.DIVISION;
        assertEquals(2.5,
             calculateur.calculer(new Operation(5, 2, operateur)));
    }

    @Test
    void diviserParZero() {
        assertThrows(CommunException.class,
             () -> calculateur.calculer(new Operation(1, 0, OperateurType.DIVISION)));
    }

    @Test
    void calculerAvecOperateur() throws CommunException {
        assertEquals(9, 
            calculateur.calculer(new Operation(3, 3, OperateurType.MULTIPLICATION)));
    }

    @Test
    void operateurInconnu() {
        assertThrows(CommunException.class,
             () -> calculateur.calculer(new Operation(1, 2, OperateurType.rechercheOperateur("_"))));
    }
}
