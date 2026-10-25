package com.example.core.commun.erreur;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CommunException extends Exception {
    public ErrorType errorType;
    private static final Logger LOGGER = Logger.getLogger(CommunException.class.getName());


    public CommunException(String message, Throwable cause) {
        super(cause.getMessage(), cause);
        if (cause instanceof NumberFormatException) {
            this.errorType = ErrorType.NUMBER_FORMAT_ERROR;
            LOGGER.info(errorType.getMessage());
            // LOGGER.log(Level.WARNING, cause.getLocalizedMessage());
        } else if (cause instanceof ArithmeticException) {
            this.errorType = ErrorType.ARITHMETIC_ERROR;
            LOGGER.info(errorType.getMessage());
            //  LOGGER.log(Level.WARNING, cause.getLocalizedMessage());
        } else if (cause instanceof ArrayIndexOutOfBoundsException) {
            this.errorType = ErrorType.ARRAY_INDEX_OUT_OF_BOUNDS_ERROR;
            // LOGGER.log(Level.WARNING, cause.getLocalizedMessage());
        } else if (cause instanceof IllegalArgumentException) {
            this.errorType = ErrorType.ILLEGAL_ARGUMENT_ERROR;
            LOGGER.info(errorType.getMessage());
            //LOGGER.log(Level.WARNING, cause.getLocalizedMessage());
        }/*else if (cause instanceof AppFormatException) {
            this.errorType = ErrorType. FORMAT_ERROR;
            LOGGER.info(errorType.getMessage());
            LOGGER.info(cause.getMessage());
            //LOGGER.log(Level.SEVERE, cause.getLocalizedMessage());
        }*/ else {
            this.errorType = ErrorType.UNDEFINED_ERROR;
            LOGGER.info(errorType.getMessage());
            LOGGER.log(Level.WARNING, cause.getMessage());
            //LOGGER.log(Level.SEVERE, cause.getLocalizedMessage());
        }
       
    }

    public ErrorType getErrorType() {
        return errorType;
    }

}
