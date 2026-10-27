package com.example.calculateur.core.commun;

import static com.example.calculateur.core.commun.erreur.ErrorType.NUMBER_FORMAT_ERROR;

import com.example.calculateur.core.commun.erreur.CommunException;

public class FormatUtils {

 public static double convertirEnNombre(String texte) throws CommunException {
        try {
            return Double.parseDouble(texte);
        } catch (NumberFormatException e) {
            throw new CommunException(NUMBER_FORMAT_ERROR, e);
        }
    }
}
