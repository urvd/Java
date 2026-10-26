package com.example.calculateur.core.calcul;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.example.calculateur.core.commun.erreur.CommunException;
import com.example.calculateur.core.resultat.Resultat;

class CalculateurTest {

    private final ICalcul calculateur = new Calculateur();

    @Test
    void additionner() throws CommunException {
        OperateurType operateur = OperateurType.ADDITION;
        Resultat resultat = calculateur.calculer(new Operation(3, 4, operateur));
        assertEquals(7, resultat.valeur());
    }

    @Test
    void soustraire() throws CommunException {
        OperateurType operateur = OperateurType.SOUSTRACTION;
        Resultat resultat = calculateur.calculer(new Operation(3, 4, operateur));
        assertEquals(-1, resultat.valeur());
    }

    @Test
    void multiplier() throws CommunException {
        OperateurType operateur = OperateurType.MULTIPLICATION;
        Resultat resultat = calculateur.calculer(new Operation(3, 4, operateur));
        assertEquals(12, resultat.valeur() );
    }

    @Test
    void calculerAutreOperateurMultiplication() throws CommunException {
        Resultat resultat = calculateur
            .calculer(new Operation(3, 3, 
                OperateurType.MULTIPLICATION_X));
        assertEquals(9, resultat.valeur());
    }

        @Test
    void diviser() throws CommunException {
        OperateurType operateur = OperateurType.DIVISION;
        Resultat resultat = calculateur.calculer(new Operation(5, 2, operateur));
        assertEquals(2.5, resultat.valeur());
    }
    /** Exception centralisée
     * Test : la division par zéro et l'opérateur inconnu.
     */
    @Test
    void diviserParZero() {
        assertThrows(CommunException.class,
             () -> calculateur.calculer(new Operation(1, 0, OperateurType.DIVISION)));
    }

    @Test
    void operateurInconnu() {
        assertThrows(CommunException.class,
             () -> calculateur.calculer(new Operation(1, 2, OperateurType.rechercheOperateur("_"))));
    }
}
