package edu.bdeb.a10.view;

import edu.bdeb.a10.persistence.*;
import edu.bdeb.a10.service.RevenueCanadaService;
import edu.bdeb.a10.service.RevenueQuebecService;

import java.util.Scanner;

public class TaxwiseVue {

    public static void calculatriceVue() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Entrer votre nom : ");
        String nom = scan.next();


        System.out.println("Entrer votre revenu annuel : ");
        String revenu = scan.next();
        double montant = Double.parseDouble(revenu);


        //ITranchesRevenu dao = new TranchesRevenuDAO_InMemory();
        ITranchesRevenuDAO daotaux = new TranchesRevenuDAO_JDBC();

        IAutoriteFiscaleDAO daoSeuil=new AutoriteFiscaleDAO_JDBC();
        RevenueCanadaService calculCa=new RevenueCanadaService(daotaux,daoSeuil);
        double taxeCa = calculCa.calculTaxe(montant);
        System.out.println("taxe Canada"+taxeCa);
        RevenueQuebecService calculQc=new RevenueQuebecService(daotaux,daoSeuil);
        double taxeQC = calculQc.calculTaxe(montant);

        System.out.println("taxe Quebec"+taxeQC);
    }


}

