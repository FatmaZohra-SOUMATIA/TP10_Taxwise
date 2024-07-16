package edu.bdeb.a10.persistence;

import edu.bdeb.a10.dataStore.DB_Connector;
import edu.bdeb.a10.model.AutoriteFiscale;
import jakarta.persistence.EntityTransaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AutoriteFiscaleDAO_JDBC implements IAutoriteFiscaleDAO {
    Connection connexion;

    public AutoriteFiscaleDAO_JDBC() {
        this.connexion = DB_Connector.getInstance().getConnection();
    }

    @Override
    public double rechercheSeuil(String autorite) {
        try {
            PreparedStatement pst = this.connexion.prepareStatement(QueryBox.TROUVER_SUEUIL);
            pst.setString(1, "%" + autorite + "%");
            ResultSet result = pst.executeQuery(); //le resultat est un enregistrement
            if (result.next()) {  //s il y a au moins un enregistrement dans l objet result
                return result.getDouble("seuil_exonere");  // prendre le champ(attribut "seuil_exonere") en le convertissant en double
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }

    @Override
    public void ajouterAutorite(AutoriteFiscale autoriteFiscale) {
        PreparedStatement pst = null;
        try {
            pst = this.connexion.prepareStatement(QueryBox.AJOUTER_AUTORITE_FISCALE);
            pst.setString(1, autoriteFiscale.getNom());
            pst.setDouble(2, autoriteFiscale.getSeuilExonere());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void modifierSeuilAutorite(int id, double seuil) {
        PreparedStatement pst = null;
        try {
            pst = this.connexion.prepareStatement(QueryBox.MODIFIER_SEUIL_AUTORITE_FISCALE);
            pst.setDouble(1, seuil);
            pst.setDouble(2, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void supprimerAutorite(int id) {
        PreparedStatement pst = null;
        try {
            pst = this.connexion.prepareStatement(QueryBox.SUPPRIMER_AUTORITE_FISCALE);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
