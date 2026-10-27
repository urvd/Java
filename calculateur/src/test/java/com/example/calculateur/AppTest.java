package com.example.calculateur;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test de bout en bout : simule une saisie utilisateur et lit l'affichage
 * (slf4j-simple écrit sur System.err).
 */
class AppTest {

    private final InputStream entreeOrigine = System.in;
    private final PrintStream sortieOrigine = System.err;
    private final ByteArrayOutputStream sortie = new ByteArrayOutputStream();

    @BeforeEach
    void rediriger() {
        System.setErr(new PrintStream(sortie, true, StandardCharsets.UTF_8));
    }

    @AfterEach
    void restaurer() {
        System.setIn(entreeOrigine);
        System.setErr(sortieOrigine);
    }

    private String lancer(String saisie) {
        System.setIn(new ByteArrayInputStream(saisie.getBytes(StandardCharsets.UTF_8)));
        App.main(new String[0]);
        return sortie.toString(StandardCharsets.UTF_8);
    }

    @Test
    void recalculerAvecR() {
        String affichage = lancer("2 + 3\nr\n+ 4\nq\n");

        assertFalse(affichage.contains("Format de saisie incorrect"));
        assertTrue(affichage.contains("Saisir (5.0) >"));
        assertTrue(affichage.contains("Resultat =  {9.0}"));
    }

    @Test
    void recalculerAvecS() {
        String affichage = lancer("2 + 3\ns\n* 2\nq\n");

        assertFalse(affichage.contains("Format de saisie incorrect"));
        assertTrue(affichage.contains("Saisir (5.0) >"));
        assertTrue(affichage.contains("Resultat =  {10.0}"));
    }

    @Test
    void formatIncorrect() {
        String affichage = lancer("2\nq\n");

        assertTrue(affichage.contains("Format de saisie incorrect"));
    }

    @Test
    void finDeSaisieSansQuitter() {
        String affichage = lancer("2 + 3\n");

        assertTrue(affichage.contains("Resultat =  {5.0}"));
        assertTrue(affichage.contains("Fin du programme"));
    }
}
