package edu.bdeb.a10.persistence;

import edu.bdeb.a10.dataStore.DB_Connector;
import edu.bdeb.a10.model.TranchesRevenu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TranchesRevenuDAO_JDBC implements ITranchesRevenuDAO {
    Connection connexion;

    public TranchesRevenuDAO_JDBC() {
        this.connexion = DB_Connector.getInstance().getConnection();
    }

    @Override
    public List<TranchesRevenu> rechercheTaux(String autorite, double montant) {
        List<TranchesRevenu> tranchesRevenu = new ArrayList<>();
        try {
            PreparedStatement pst = this.connexion.prepareStatement(QueryBox.TROUVER_TRANCHE_REVENU_PAR_NOM_AUTORITE);
            pst.setString(1, "%" + autorite + "%");
            pst.setDouble(2, montant);
            ResultSet result = pst.executeQuery(); //le resultat est un enregistrement
            while (result.next()) {  //s il y a au moins un enregistrement dans l objet result
                int id = result.getInt("id");
                double trancheMin = result.getDouble("tranche_min");
                double trancheMax = result.getDouble("tranche_max");
                double tauxImposition = result.getDouble("taux_imposition");
                tranchesRevenu.add(new TranchesRevenu(id, trancheMin, trancheMax, tauxImposition));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return tranchesRevenu;
    }

    @Override
    public void ajouterTranchesRevenu(TranchesRevenu tranche) {
        PreparedStatement pst = null;
        try {
            pst = this.connexion.prepareStatement(QueryBox.AJOUTER_TRANCHE_REVENU);
            pst.setDouble(1, tranche.getTrancheMin());
            pst.setDouble(2, tranche.getTrancheMax());
            pst.setDouble(3, tranche.getTauxImposition());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void modifierTranchesRevenu(TranchesRevenu tranchesRevenu) {
        PreparedStatement pst = null;
        try {
            pst = this.connexion.prepareStatement(QueryBox.MODIFIER_TRANCHE_REVENU);
            pst.setDouble(1, tranchesRevenu.getTrancheMin());
            pst.setDouble(2, tranchesRevenu.getTrancheMax());
            pst.setDouble(3, tranchesRevenu.getTauxImposition());
            pst.setInt(4, tranchesRevenu.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void supprimerTranchesRevenuAutorite(int id) {
        PreparedStatement pst = null;
        try {
            pst = this.connexion.prepareStatement(QueryBox.SUPPRIMER_TRANCHE_REVENU_PAR_ID);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
