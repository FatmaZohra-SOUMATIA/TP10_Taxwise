package edu.bdeb.a10.persistence;

public interface IAutoriteFiscaleDAO {



    double rechercheSeuil(String autorite);
    int ajouterAutorite(String autorite,double seuil);
    int modifierSeuilAutorite(String autorite,double seuil);
    int supprimerAutorite(String autorite);
}
