package edu.bdeb.a10.persistence;

public class QueryBox {

    public static final String AJOUTER_TRANCHE_REVENU = "INSERT INTO TranchesRevenu ( tranche_min, tranche_MAX, taux_imposition)\n" +
            "VALUES (?, ?, ?, ?)";

    //requete sql pour trouver le seuil exonéré d une autorité
    static String TROUVER_SUEUIL = "SELECT seuil_exonere FROM AutoriteFiscale WHERE nom LIKE ?";

    // suppr rqt
    static String SUPPRIMER_TRANCHE_REVENU_PAR_NOM_AUTORITE = "DELETE FROM TranchesRevenu tr " +
            "JOIN AutoriteFiscale af ON tr.autorite_fiscale_id = af.id " +
            "WHERE af.nom LIKE ?";


    //requete sql
    static String TROUVER_TRANCHE_REVENU_PAR_NOM_AUTORITE = "SELECT tr.id, tr.tranche_min, tr.tranche_max, tr.taux_imposition " +
            "FROM TranchesRevenu tr " +
            "JOIN AutoriteFiscale af ON tr.autorite_fiscale_id = af.id " +
            "WHERE af.nom LIKE ? AND tr.tranche_min <= ?";

}