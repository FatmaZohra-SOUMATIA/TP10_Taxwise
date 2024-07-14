package edu.bdeb.a10.persistence;

public interface IAutoriteFiscaleDAO {


    // Recherche le seuil exonéré pour une autorité fiscale spécifique.
    double rechercheSeuil(String autorite);

    //Ajoute une nouvelle autorité fiscale avec un seuil exonéré spécifié.
    int ajouterAutorite(String autorite, double seuil);

    // Modifie le seuil exonéré d'une autorité fiscale spécifique.
    int modifierSeuilAutorite(String autorite, double seuil);

    // Supprime une autorité fiscale spécifique.
    int supprimerAutorite(String autorite);
}
