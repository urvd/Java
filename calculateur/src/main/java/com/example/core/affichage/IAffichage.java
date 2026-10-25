package com.example.core.affichage;
import com.example.core.commun.erreur.CommunException;

public interface IAffichage {
    public void commencer();
    public void terminer();
    public void afficher(String texte);
    public boolean verifierAnnulation(String ligne);
    //public boolean verifierCaratereOk(String ligne);
    public boolean verifierFormatOk(String ligne) throws CommunException;
}
 