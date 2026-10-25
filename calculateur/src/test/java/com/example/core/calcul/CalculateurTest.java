package com.example.core.calcul;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.example.core.commun.erreur.CommunException;

class CalculateurTest {

    private final ICalcul calculateur = new Calculateur();

    @Test
    void additionner() throws CommunException {
        assertEquals(7, calculateur.calculer(3, '+', 4));
    }

    @Test
    void soustraire() throws CommunException {
        assertEquals(-1, calculateur.calculer(3,'-', 4));
    }

    @Test
    void multiplier() throws CommunException {
        assertEquals(12, calculateur.calculer(3, '*', 4));
    }

    @Test
    void diviser() throws CommunException {
        assertEquals(2.5, calculateur.calculer(5, '/', 2));
    }

    @Test
    void diviserParZero() {
        assertThrows(CommunException.class, () -> calculateur.calculer(1, '/', 0));
    }

    @Test
    void calculerAvecOperateur() throws CommunException {
        assertEquals(9, calculateur.calculer(3, '*', 3));
    }

    @Test
    void operateurInconnu() {
        assertThrows(CommunException.class, () -> calculateur.calculer(1, '%', 2));
    }
}
