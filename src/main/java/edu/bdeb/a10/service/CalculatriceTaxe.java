package edu.bdeb.a10.service;

import edu.bdeb.a10.model.TranchesRevenu;
import edu.bdeb.a10.persistence.IAutoriteFiscaleDAO;
import edu.bdeb.a10.persistence.ITranchesRevenuDAO;

import java.util.List;

/**
 * La classe CalculatriceTaxe fournit des méthodes pour calculer la taxe en fonction
 * des tranches de revenu et des seuils fiscaux.
 */

public class CalculatriceTaxe {

    protected ITranchesRevenuDAO daoTaux;
    protected IAutoriteFiscaleDAO daoSeuil;

    /**
     * Constructeur de la classe CalculatriceTaxe.
     *
     * @param daoTaux  DAO pour accéder aux données des tranches de revenu.
     * @param daoSeuil DAO pour accéder aux données des seuils fiscaux.
     */
    public CalculatriceTaxe(ITranchesRevenuDAO daoTaux, IAutoriteFiscaleDAO daoSeuil) {
        this.daoTaux = daoTaux;
        this.daoSeuil = daoSeuil;
    }

    /**
     * Calcule la taxe pour un montant donné en utilisant les informations spécifiques
     * à une autorité fiscale.
     *
     * @param montant  Le montant sur lequel la taxe doit être calculée.
     * @param autorite Le nom de l'autorité fiscale.
     * @return Le montant de la taxe calculée.
     */
    public double calculTaxe(double montant, String autorite) {
        double taxe = 0;
        double seuil = daoSeuil.rechercheSeuil(autorite);
        System.out.println(seuil);
        System.out.println(autorite);
        List<TranchesRevenu> listeTranches = daoTaux.rechercheTaux(autorite, montant);
        if (montant >= seuil) {

            for (TranchesRevenu tr : listeTranches) {
                if (montant > tr.getTrancheMax()){
                    taxe += (tr.getTrancheMax() - tr.getTrancheMin()) * (tr.getTauxImposition()/100);
                System.out.println(" dans IF max = "+tr.getTrancheMax()+ " Min = "+tr.getTrancheMin()+ " taux = "+tr.getTauxImposition());
                }
                else {
                    if(tr.getTrancheMin()==0){
                        taxe += (montant - seuil) * (tr.getTauxImposition()/100);

                    }else {
                        taxe += (montant - tr.getTrancheMin()) * (tr.getTauxImposition() / 100);
                        System.out.println(" dans ELSE max = " + tr.getTrancheMax() + " Min = " + tr.getTrancheMin());
                    }
                }
            }

        }
        return taxe;
    }
}
