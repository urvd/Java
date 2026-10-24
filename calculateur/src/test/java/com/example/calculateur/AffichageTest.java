package com.example.calculateur;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.example.affichage.Affichage;
import com.example.affichage.IAffichage;

public class AffichageTest {
    private final IAffichage affichage = new Affichage();
    private static final String TEXTE_ANNULATION = "q";
    private static final String TEXTE_AUTRE  = "p";
    private static final String TEXTE_FORMAT_OK1 = "3 x 3";
    private static final String TEXTE_FORMAT_OK2 = "L S U";
    private static final String TEXTE_FORMAT_OK3 = "L S  U";
    private static final String TEXTE_FORMAT_STR1 = "LSU";
    private static final String TEXTE_FORMAT_STR2 = "L";
     private static final String TEXTE_FORMAT_STR3 = "45-79";

    @Test 
    void affichage_verification_annulation() {
        assertTrue(affichage.verifierAnnulation(TEXTE_ANNULATION));
    }

     @Test 
    void affichage_verification_format_forrect() {
        assertTrue(affichage.verifierFormatOk(TEXTE_FORMAT_OK1));
        assertTrue(affichage.verifierFormatOk(TEXTE_FORMAT_OK2));
        assertTrue(affichage.verifierFormatOk(TEXTE_FORMAT_OK3));
    }

    @Test 
    void affichage_verification_format_non_correct() {
        assertFalse(affichage.verifierFormatOk(TEXTE_FORMAT_STR1));
        assertFalse(affichage.verifierFormatOk(TEXTE_FORMAT_STR2));
        assertFalse(affichage.verifierFormatOk(TEXTE_FORMAT_STR3));
    }
}
