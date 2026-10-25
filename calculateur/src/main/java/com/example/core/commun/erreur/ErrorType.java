package com.example.core.commun.erreur;

public enum ErrorType {
    FORMAT_ERROR("Format de saisie incorrect"),
    NUMBER_FORMAT_ERROR("Erreur de format numérique !"),
    ARITHMETIC_ERROR("Erreur arithmétique !"),
    ARRAY_INDEX_OUT_OF_BOUNDS_ERROR("Saisie invalide !"),
    ILLEGAL_ARGUMENT_ERROR("Argument invalide !"),
    UNDEFINED_ERROR("Erreur indéfinie !");

    private final String message;

    ErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
