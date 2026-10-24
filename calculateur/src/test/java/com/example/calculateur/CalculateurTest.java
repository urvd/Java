package com.example.calculateur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.example.calcul.Calculateur;

class CalculateurTest {

    private final Calculateur calculateur = new Calculateur();

    @Test
    void additionner() {
        assertEquals(7, calculateur.additionner(3, 4));
    }

    @Test
    void soustraire() {
        assertEquals(-1, calculateur.soustraire(3, 4));
    }

    @Test
    void multiplier() {
        assertEquals(12, calculateur.multiplier(3, 4));
    }

    @Test
    void diviser() {
        assertEquals(2.5, calculateur.diviser(5, 2));
    }

    @Test
    void diviserParZero() {
        assertThrows(ArithmeticException.class, () -> calculateur.diviser(1, 0));
    }

    @Test
    void calculerAvecOperateur() {
        assertEquals(9, calculateur.calculer(3, '*', 3));
    }

    @Test
    void operateurInconnu() {
        assertThrows(IllegalArgumentException.class, () -> calculateur.calculer(1, '%', 2));
    }
}
