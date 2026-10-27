package com.example.calculateur.core.calcul;

public record Operation( double operande1, double operande2, OperateurType operateur) {
    public Operation(){
        this(0,0, OperateurType.ADDITION);
    }
}
    
