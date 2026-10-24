package com.example.affichage;

public interface IAffichage {
    public void commencer();
    public void terminer();
    public void afficher(String texte);
    public boolean verifierCaratereOk(String ligne);
    public boolean verifierFormatOk(String ligne);
}
