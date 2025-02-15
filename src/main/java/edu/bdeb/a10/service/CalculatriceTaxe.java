package edu.bdeb.a10.service;

import edu.bdeb.a10.model.TranchesRevenu;
import edu.bdeb.a10.persistence.IAutoriteFiscaleDAO;
import edu.bdeb.a10.persistence.ITranchesRevenuDAO;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * La classe de base CalculatriceTaxe fournit des méthodes pour calculer la taxe en fonction
 * des tranches de revenu et des seuils fiscaux.
 * la classe mère de RevenueCanadaService &  * RevenueQuebecService
 */

public class CalculatriceTaxe {

    protected ITranchesRevenuDAO daoTaux;
    protected IAutoriteFiscaleDAO daoSeuil;

   // Constructeur de la classe CalculatriceTaxe.

    public CalculatriceTaxe(ITranchesRevenuDAO daoTaux, IAutoriteFiscaleDAO daoSeuil) {
        this.daoTaux = daoTaux;
        this.daoSeuil = daoSeuil;
    }

    // Calcule la taxe pour un montant donné selon l autorite

    public double calculTaxe(double montant, String autorite) {
        double taxe = 0;
        // Récupère le seuil pour l'autorité fiscale donnée
        double seuil = daoSeuil.rechercheSeuil(autorite);

        // Récupère la liste des tranches de revenu pour l'autorité fiscale et le montant donné
        List<TranchesRevenu> listeTranches = daoTaux.rechercheTaux(autorite, montant);


        // Vérifie si le montant est supérieur ou égal au seuil
        if (montant >= seuil) {
            // Parcourt chaque tranche de revenu
            for (TranchesRevenu tr : listeTranches) {
                // Si le montant est supérieur à la tranche maximale
                if (montant > tr.getTrancheMax()) {
                    // Si la tranche minimale est zéro, applique une logique différente
                    if (tr.getTrancheMin() == 0){
                        // Calcule la taxe pour le montant au-dessus du seuil
                        taxe += (tr.getTrancheMax() - seuil) * (tr.getTauxImposition() / 100);
                    }else{
                        // Calcule la taxe pour cette tranche
                        taxe += (tr.getTrancheMax() - tr.getTrancheMin()) * (tr.getTauxImposition() / 100);
                    }
                } else {
                    if (tr.getTrancheMin() == 0){
                        // Calcule la taxe pour le montant au-dessus du seuil
                        taxe += (montant - seuil) * (tr.getTauxImposition() / 100);
                    }else {
                        // Calcule la taxe pour la partie du montant dans cette tranche
                        taxe += (montant - tr.getTrancheMin()) * (tr.getTauxImposition() / 100);

                    }
                }
            }
        }
        // Utilisation de BigDecimal pour arrondir à deux chiffres décimaux
        BigDecimal taxeArrondie = new BigDecimal(taxe).setScale(2, RoundingMode.HALF_UP);
        return taxeArrondie.doubleValue();

    }
}
