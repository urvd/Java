package com.example.calculateur.core.commun.erreur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static com.example.calculateur.core.commun.erreur.ErrorType.*;


import org.junit.jupiter.api.Test;


class CommunExceptionTest {

    @Test
    void reconnaitNumberFormatException() {
        Throwable cause = new NumberFormatException("nombre invalide");
        CommunException exception = new CommunException(NUMBER_FORMAT_ERROR, cause);

        assertEquals(ErrorType.NUMBER_FORMAT_ERROR, exception.getErrorType());
        //assertSame(cause, exception.getCause());
    }

    @Test
    void reconnaitArithmeticException() {
        Throwable cause = new ArithmeticException("division par zéro");
        CommunException exception = new CommunException(ARITHMETIC_ERROR, cause);

        assertEquals(ErrorType.ARITHMETIC_ERROR, exception.getErrorType());
        //assertSame(cause, exception.getCause());
    }

    @Test
    void reconnaitArrayIndexOutOfBoundsException() {
        Throwable cause = new ArrayIndexOutOfBoundsException(5);
        CommunException exception = new CommunException(ARRAY_INDEX_OUT_OF_BOUNDS_ERROR, cause);

        assertEquals(ErrorType.ARRAY_INDEX_OUT_OF_BOUNDS_ERROR, exception.getErrorType());
        //assertSame(cause, exception.getCause());
    }

    @Test
    void reconnaitIllegalArgumentException() {
        Throwable cause = new IllegalArgumentException("argument invalide");
        CommunException exception = new CommunException(ILLEGAL_ARGUMENT_ERROR, cause);

        assertEquals(ErrorType.ILLEGAL_ARGUMENT_ERROR, exception.getErrorType());
        //assertSame(cause, exception.getCause());
    }

    @Test
    void reconnaitIAutreUncatchedException() {
        Throwable cause = new Exception("argument invalide");
        CommunException exception = new CommunException(UNDEFINED_ERROR, cause);

        assertEquals(ErrorType.UNDEFINED_ERROR, exception.getErrorType());
        //assertSame(cause, exception.getCause());
    }
}
