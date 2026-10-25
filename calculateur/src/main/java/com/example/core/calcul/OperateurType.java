package com.example.core.calcul;

public enum OperateurType {
ADDITION("+"),
    SOUSTRACTION("-"),
    MULTIPLICATION("*"),
    MULTIPLICATION_X("x"),
    DIVISION("/");

    private final String symbole;

    OperateurType(String symbole) {
        this.symbole = symbole;
    }

    public String getSymbole() {
        return symbole;
    }

    public static OperateurType rechercheOperateur(String symbole) {
        for (OperateurType operateur : values()) {
            if (operateur.symbole.equals(symbole)) {
                return operateur;
            }
        }
        throw new IllegalArgumentException("Opérateur inconnu : " + symbole);
    }
}
