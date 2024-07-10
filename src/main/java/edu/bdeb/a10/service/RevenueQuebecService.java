package edu.bdeb.a10.service;

import edu.bdeb.a10.persistence.IAutoriteFiscaleDAO;
import edu.bdeb.a10.persistence.ITranchesRevenuDAO;

/**
 * La classe RevenueQuebecService hérite de CalculatriceTaxe et fournit des fonctionnalités spécifiques
 * pour l'Agence du revenu du Québec.
 */
public class RevenueQuebecService extends CalculatriceTaxe {
    private String autorite = "Québec";

    /**
     * Constructeur de la classe RevenueQuebecService.
     *
     * @param daoTaux  DAO pour accéder aux données des tranches de revenu.
     * @param daoSeuil DAO pour accéder aux données des seuils fiscaux.
     */
    public RevenueQuebecService(ITranchesRevenuDAO daoTaux, IAutoriteFiscaleDAO daoSeuil) {
        super(daoTaux, daoSeuil);
    }

    /**
     * Calcule la taxe pour un montant donné en utilisant les informations spécifiques
     * à l'Agence du revenu du Québec.
     *
     * @param montant Le montant sur lequel la taxe doit être calculée.
     * @return Le montant de la taxe calculée.
     */
    public double calculTaxe(double montant) {
        // Appel de la méthode calculTaxe de la classe parente, en passant le montant et le nom de l'autorité fiscale
        return super.calculTaxe(montant, this.autorite);
    }
}
