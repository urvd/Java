package com.example.calculateur.core.calcul;

import com.example.calculateur.core.commun.erreur.CommunException;

public interface ICalcul {
    public double calculer(Operation operation) throws CommunException;
}
