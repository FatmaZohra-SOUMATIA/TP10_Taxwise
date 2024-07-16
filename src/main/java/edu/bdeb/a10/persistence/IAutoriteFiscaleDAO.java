package edu.bdeb.a10.persistence;

import edu.bdeb.a10.model.AutoriteFiscale;

/**
 * Interface définit les opérations CRUD pour les différents DAO communicant avec la table AutoriteFiscale.
 */
public interface IAutoriteFiscaleDAO {


    // Recherche le seuil exonéré pour une autorité fiscale spécifique.
    double rechercheSeuil(String autorite);

    //Ajoute une nouvelle autorité fiscale avec un seuil exonéré spécifié.
    void ajouterAutorite(AutoriteFiscale autoriteFiscale);

    // Modifie le seuil exonéré d'une autorité fiscale spécifique.
    void modifierSeuilAutorite(int id, double seuil);

    // Supprime une autorité fiscale spécifique.
    void supprimerAutorite(int id);
}
