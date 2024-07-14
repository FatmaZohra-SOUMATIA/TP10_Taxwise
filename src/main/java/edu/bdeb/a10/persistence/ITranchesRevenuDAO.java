package edu.bdeb.a10.persistence;

import edu.bdeb.a10.model.TranchesRevenu;

import java.util.List;

/**
 * Interface pour les opérations DAO (Data Access Object) sur les tranches de revenu.
 */
public interface ITranchesRevenuDAO {

    // Recherche les tranches de revenu pour une autorité fiscale donnée et un montant donné.
    List<TranchesRevenu> rechercheTaux(String autorite, double montant);

    // Ajoute une nouvelle tranche de revenu dans la base de données.
    int ajouterTranchesRevenu(TranchesRevenu tranche);

    //Modifie une tranche de revenu existante dans la base de données.
    int modifierTranchesRevenu(TranchesRevenu tranche);

    // Supprime toutes les tranches de revenu pour une autorité fiscale donnée.
    int supprimerTranchesRevenuAutorite(String autorite);
}

