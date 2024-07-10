package edu.bdeb.a10.persistence;

import edu.bdeb.a10.model.TranchesRevenu;

import java.util.List;
/**
 * Interface pour les opérations DAO (Data Access Object) sur les tranches de revenu.
 */
public interface ITranchesRevenuDAO {

    /**
     * Recherche les tranches de revenu pour une autorité fiscale donnée et un montant donné.
     *
     * @param autorite Le nom de l'autorité fiscale.
     * @param montant Le montant sur lequel les tranches de revenu sont recherchées.
     * @return Une liste de tranches de revenu correspondant à l'autorité fiscale et au montant donnés.
     */
    List<TranchesRevenu> rechercheTaux(String autorite, double montant);
    /**
     * Ajoute une nouvelle tranche de revenu dans la base de données.
     *
     * @param tranche La tranche de revenu à ajouter.
     * @return Un entier indiquant le résultat de l'opération (ex. : 1 pour succès, 0 pour échec).
     */
    int ajouterTranchesRevenu(TranchesRevenu tranche);

    /**
     * Modifie une tranche de revenu existante dans la base de données.
     *
     * @param tranche La tranche de revenu à modifier.
     * @return Un entier indiquant le résultat de l'opération (ex. : 1 pour succès, 0 pour échec).
     */
    int modifierTranchesRevenu(TranchesRevenu tranche);
    /**
     * Supprime toutes les tranches de revenu pour une autorité fiscale donnée.
     *
     * @param autorite Le nom de l'autorité fiscale pour laquelle les tranches de revenu doivent être supprimées.
     * @return Un entier indiquant le résultat de l'opération (ex. : 1 pour succès, 0 pour échec).
     */
    int supprimerTranchesRevenuAutorite(String autorite);
}

