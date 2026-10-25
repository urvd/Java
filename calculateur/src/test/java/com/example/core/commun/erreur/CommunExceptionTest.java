package com.example.core.commun.erreur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.IllegalFormatException;

import org.junit.jupiter.api.Test;

class CommunExceptionTest {

    @Test
    void reconnaitNumberFormatException() {
        Throwable cause = new NumberFormatException("nombre invalide");
        CommunException exception = new CommunException("Erreur", cause);

        assertEquals(ErrorType.NUMBER_FORMAT_ERROR, exception.getErrorType());
        assertSame(cause, exception.getCause());
    }

    @Test
    void reconnaitArithmeticException() {
        Throwable cause = new ArithmeticException("division par zéro");
        CommunException exception = new CommunException("Erreur", cause);

        assertEquals(ErrorType.ARITHMETIC_ERROR, exception.getErrorType());
        assertSame(cause, exception.getCause());
    }

    @Test
    void reconnaitArrayIndexOutOfBoundsException() {
        Throwable cause = new ArrayIndexOutOfBoundsException(5);
        CommunException exception = new CommunException("Erreur", cause);

        assertEquals(ErrorType.ARRAY_INDEX_OUT_OF_BOUNDS_ERROR, exception.getErrorType());
        assertSame(cause, exception.getCause());
    }

    @Test
    void reconnaitIllegalArgumentException() {
        Throwable cause = new IllegalArgumentException("argument invalide");
        CommunException exception = new CommunException("Erreur", cause);

        assertEquals(ErrorType.ILLEGAL_ARGUMENT_ERROR, exception.getErrorType());
        assertSame(cause, exception.getCause());
    }

    @Test
    void reconnaitIAutreUncatchedException() {
        Throwable cause = new Exception("argument invalide");
        CommunException exception = new CommunException("Erreur inconnu", cause);

        assertEquals(ErrorType.UNDEFINED_ERROR, exception.getErrorType());
        assertSame(cause, exception.getCause());
    }
}
