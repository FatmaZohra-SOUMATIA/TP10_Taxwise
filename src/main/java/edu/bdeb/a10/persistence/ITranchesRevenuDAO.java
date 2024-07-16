package edu.bdeb.a10.persistence;

import edu.bdeb.a10.model.TranchesRevenu;

import java.util.List;

/**
 * Interface définit les opérations CRUD pour les différents DAO communicant avec la table TranchesRevenu.
 */
public interface ITranchesRevenuDAO {

    // Recherche les tranches de revenu pour une autorité fiscale donnée et un montant donné.
    List<TranchesRevenu> rechercheTaux(String autorite, double montant);

    // Ajoute une nouvelle tranche de revenu dans la base de données.
    void ajouterTranchesRevenu(TranchesRevenu tranche);

    //Modifie une tranche de revenu existante dans la base de données.
    void modifierTranchesRevenu(TranchesRevenu tranchesRevenu);

    // Supprime toutes les tranches de revenu pour une autorité fiscale donnée.
    void supprimerTranchesRevenuAutorite(int id);
}

