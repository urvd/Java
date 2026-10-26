package com.example.calculateur.core.affichage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.example.calculateur.core.action.ActionType;
import com.example.calculateur.core.commun.erreur.CommunException;

public class AffichageTest {
    private final IAffichage affichage = new Affichage();
    private static final String TEXTE_ANNULATION = "q";
    private static final String TEXTE_RECALCULER = "r";
    private static final String TEXTE_CALCULER = "c";
    private static final String TEXTE_AUTRE  = "p";
    private static final String TEXTE_FORMAT_OK1 = "3 x 3";
    private static final String TEXTE_FORMAT_OK2 = "L S U";
    private static final String TEXTE_FORMAT_OK3 = "L S  U";
    private static final String TEXTE_FORMAT_STR0 = " S U";
    private static final String TEXTE_FORMAT_STR1 = "LSU";
    private static final String TEXTE_FORMAT_STR2 = "L";
     private static final String TEXTE_FORMAT_STR3 = "45-79";

    @Test 
    void affichage_verification_annulation() {
        assertEquals(ActionType.QUITTER, affichage.verifierActionUser(TEXTE_ANNULATION));
    }
        @Test 
    void affichage_verification_calculer() {
        assertEquals(ActionType.CALCULER, affichage.verifierActionUser(TEXTE_CALCULER));
        assertEquals(ActionType.CALCULER, affichage .verifierActionUser(TEXTE_AUTRE));
    }
        @Test 
    void affichage_verification_recalculer() {
        assertEquals(ActionType.RECALCULER, affichage.verifierActionUser(TEXTE_RECALCULER));
    }

     @Test 
    void affichage_verification_format_forrect() throws CommunException {
        assertTrue(affichage.verifierFormatOk(TEXTE_FORMAT_OK1));
        assertTrue(affichage.verifierFormatOk(TEXTE_FORMAT_OK2));
        assertTrue(affichage.verifierFormatOk(TEXTE_FORMAT_OK3));
    }

    @Test 
    void affichage_verification_format_non_correct() throws CommunException {
        String str0 = TEXTE_FORMAT_STR0.trim();
        assertThrows(CommunException.class, () -> affichage.verifierFormatOk(str0));
        assertThrows(CommunException.class, () -> affichage.verifierFormatOk(TEXTE_FORMAT_STR1));
        assertThrows(CommunException.class, () -> affichage.verifierFormatOk(TEXTE_FORMAT_STR2));
        assertThrows(CommunException.class, () -> affichage.verifierFormatOk(TEXTE_FORMAT_STR3));
    }
}
