package com.example.calculateur.core.commun.erreur;

//import java.util.logging.Logger;

public class CommunException extends Exception {
    private ErrorType errorType;
    //private static final Logger LOGGER = Logger.getLogger(CommunException.class.getName());


    public CommunException(ErrorType errorType, Throwable cause ) {
        super("Calcul App Error type" + " - " + cause.getMessage());
        //super("Calcul App Error type" + " - " + cause.getMessage(),cause);
        
        if (cause instanceof NumberFormatException 
            && errorType == ErrorType.NUMBER_FORMAT_ERROR) {
            setErrorType(errorType);
            //LOGGER.info(errorType.getMessage());
            //LOGGER.log(Level.OFF, cause.getMessage());
        } else if (cause instanceof ArithmeticException 
            && errorType == ErrorType.ARITHMETIC_ERROR) {
            setErrorType(errorType);
           // LOGGER.info(errorType.getMessage());
            //LOGGER.log(Level.OFF, cause.getMessage());
        } else if (cause instanceof ArrayIndexOutOfBoundsException 
            && errorType == ErrorType.ARRAY_INDEX_OUT_OF_BOUNDS_ERROR) {
            setErrorType(errorType);
            //LOGGER.log(Level.OFF, cause.getMessage());
        } else if (cause instanceof IllegalArgumentException 
            && errorType == ErrorType.ILLEGAL_ARGUMENT_ERROR
            && errorType != ErrorType.FORMAT_ERROR) {
            setErrorType(errorType);
            //LOGGER.info(errorType.getMessage());
            //LOGGER.log(Level.OFF, cause.getLocalizedMessage());
        } else {
            if (this.errorType != ErrorType.UNDEFINED_ERROR){
                setErrorType(errorType);
            }
            else this.errorType = ErrorType.UNDEFINED_ERROR;
            //LOGGER.info(errorType.getMessage());
            //LOGGER.log(Level.WARNING, cause.getMessage());
            //LOGGER.log(Level.SEVERE, cause.getLocalizedMessage());
        }
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public void setErrorType(ErrorType type) {
        this.errorType = type;
    }

}
