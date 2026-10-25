package com.example.core.calcul;

import com.example.core.commun.erreur.CommunException;

public interface ICalcul {
    public double calculer(double a, char operateur, double b) throws CommunException;
}
