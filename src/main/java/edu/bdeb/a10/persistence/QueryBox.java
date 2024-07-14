package edu.bdeb.a10.persistence;

public class QueryBox {

    /*****************CRUD sur la Table TranchesRevenu*************/

    // Requête SQL pour ajouter une nouvelle tranche de revenu dans la table TranchesRevenu
    public static final String AJOUTER_TRANCHE_REVENU =

            "INSERT INTO TranchesRevenu ( tranche_min, tranche_MAX, taux_imposition)\n" +
                    "VALUES (?, ?, ?, ?)";

    // Requête SQL pour trouver les tranches de revenu d'une autorité fiscale spécifique
    public static String TROUVER_TRANCHE_REVENU_PAR_NOM_AUTORITE =

            "SELECT tr.id, tr.tranche_min, tr.tranche_max, tr.taux_imposition " +
                    "FROM TranchesRevenu tr " +
                    "JOIN AutoriteFiscale af ON tr.autorite_fiscale_id = af.id " +
                    "WHERE af.nom LIKE ? AND tr.tranche_min <= ?";

    // Requête SQL pour supprimer les tranches de revenu d'une autorité fiscale spécifique
    public static String SUPPRIMER_TRANCHE_REVENU_PAR_NOM_AUTORITE =

            "DELETE FROM TranchesRevenu tr " +
                    "JOIN AutoriteFiscale af ON tr.autorite_fiscale_id = af.id " +
                    "WHERE af.nom LIKE ?";

    // Requête SQL pour modifier une tranche de revenu d'une autorité fiscale spécifique
    public static final String MODIFIER_TRANCHE_REVENU =
            "UPDATE TranchesRevenu " +
                    "SET tranche_min = ?, tranche_max = ?, taux_imposition = ? " +
                    "WHERE id = ?";


    /*****************CRUD sur la Table AutoritéFiscale******************/
    // Requête SQL pour ajouter une nouvelle autorité fiscale dans la table AutoritéFiscale
    public static final String AJOUTER_AUTORITE_FISCALE =
            "INSERT INTO AutoriteFiscale (nom, seuil_exonere) " +
                    "VALUES (?, ?)";

    // Requête SQL pour trouver le seuil exonéré pour une autorité fiscale spécifique
    public static String TROUVER_SUEUIL =

            "SELECT seuil_exonere FROM AutoriteFiscale WHERE nom LIKE ?";

    // Requête SQL pour supprimer une autorité fiscale spécifique
    public static final String SUPPRIMER_AUTORITE_FISCALE =
            "DELETE FROM AutoriteFiscale WHERE nom LIKE ?";

    // Requête SQL pour modifier le seuil d'une autorité fiscale spécifique
    public static final String MODIFIER_SEUIL_AUTORITE_FISCALE =
            "UPDATE AutoriteFiscale SET seuil_exonere = ? WHERE nom LIKE ?";
}