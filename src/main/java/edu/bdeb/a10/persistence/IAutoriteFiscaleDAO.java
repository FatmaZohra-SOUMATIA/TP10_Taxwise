package edu.bdeb.a10.persistence;

import edu.bdeb.a10.model.AutoriteFiscale;

public interface IAutoriteFiscaleDAO {


    // Recherche le seuil exonéré pour une autorité fiscale spécifique.
    double rechercheSeuil(String autorite);

    //Ajoute une nouvelle autorité fiscale avec un seuil exonéré spécifié.
    void ajouterAutorite(AutoriteFiscale autoriteFiscale);

    // Modifie le seuil exonéré d'une autorité fiscale spécifique.
    int modifierSeuilAutorite(String autorite, double seuil);

    // Supprime une autorité fiscale spécifique.
    int supprimerAutorite(String autorite);
}
