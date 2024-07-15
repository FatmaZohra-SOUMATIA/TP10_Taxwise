package edu.bdeb.a10.service;

import edu.bdeb.a10.persistence.IAutoriteFiscaleDAO;
import edu.bdeb.a10.persistence.ITranchesRevenuDAO;

public class RevenueCanadaService extends CalculatriceTaxe {
    private String autorite = "Agence du revenu du Canada";

    public RevenueCanadaService(ITranchesRevenuDAO daoTaux, IAutoriteFiscaleDAO daoSeuil) {
        super(daoTaux, daoSeuil);

    }


    public double calculTaxe(double montant) {

        return super.calculTaxe(montant, this.autorite);
    }
}
