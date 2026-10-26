package com.example.calculateur.core.affichage;
import com.example.calculateur.core.action.ActionType;
import com.example.calculateur.core.commun.erreur.CommunException;

public interface IAffichage {
    public void commencer();
    public void terminer();
    public void afficher(String texte);
    public ActionType verifierActionUser(String ligne);
    //public boolean verifierCaratereOk(String ligne);
    public boolean verifierFormatOk(String ligne) throws CommunException;
}
 