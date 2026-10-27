package com.example.calculateur.core.calcul;

import com.example.calculateur.core.commun.erreur.CommunException;
import com.example.calculateur.core.resultat.Resultat;

public interface ICalcul {
    public Resultat calculer(Operation operation) throws CommunException;
}
