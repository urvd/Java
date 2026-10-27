package com.example.calculateur.core.commun;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.example.calculateur.core.commun.erreur.CommunException;
import com.example.calculateur.core.commun.erreur.ErrorType;

class FormatUtilsTest {

    @Test
    void convertirEntier() throws CommunException {
        assertEquals(42, FormatUtils.convertirEnNombre("42"));
    }

    @Test
    void convertirNombreDecimal() throws CommunException {
        assertEquals(3.5, FormatUtils.convertirEnNombre("3.5"));
    }

    @Test
    void convertirNombreNegatif() throws CommunException {
        assertEquals(-7, FormatUtils.convertirEnNombre("-7"));
    }

    @Test
    void convertirZero() throws CommunException {
        assertEquals(0, FormatUtils.convertirEnNombre("0"));
    }

    @Test
    void convertirNotationScientifique() throws CommunException {
        assertEquals(1500, FormatUtils.convertirEnNombre("1.5e3"));
    }

    @Test
    void convertirAvecEspacesAutour() throws CommunException {
        assertEquals(12, FormatUtils.convertirEnNombre(" 12 "));
    }

    /** Exception centralisée
     * Test : les saisies non numériques donnent une NUMBER_FORMAT_ERROR.
     */
    @Test
    void texteNonNumerique() {
        CommunException exception = assertThrows(CommunException.class,
             () -> FormatUtils.convertirEnNombre("abc"));
        assertEquals(ErrorType.NUMBER_FORMAT_ERROR, exception.getErrorType());
    }

    @Test
    void virguleDecimale() {
        CommunException exception = assertThrows(CommunException.class,
             () -> FormatUtils.convertirEnNombre("3,5"));
        assertEquals(ErrorType.NUMBER_FORMAT_ERROR, exception.getErrorType());
    }

    @Test
    void operateurAuLieuDUnNombre() {
        CommunException exception = assertThrows(CommunException.class,
             () -> FormatUtils.convertirEnNombre("+"));
        assertEquals(ErrorType.NUMBER_FORMAT_ERROR, exception.getErrorType());
    }

    @Test
    void texteVide() {
        CommunException exception = assertThrows(CommunException.class,
             () -> FormatUtils.convertirEnNombre(""));
        assertEquals(ErrorType.NUMBER_FORMAT_ERROR, exception.getErrorType());
    }

    /**
     * Comportement actuel : null n'est pas converti en CommunException,
     * la NullPointerException de Double.parseDouble remonte telle quelle.
     */
    @Test
    void texteNull() {
        assertThrows(NullPointerException.class, () -> FormatUtils.convertirEnNombre(null));
    }
}
