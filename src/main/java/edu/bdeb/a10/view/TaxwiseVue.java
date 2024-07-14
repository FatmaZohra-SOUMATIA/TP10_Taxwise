package edu.bdeb.a10.view;

import edu.bdeb.a10.persistence.*;
import edu.bdeb.a10.service.RevenueCanadaService;
import edu.bdeb.a10.service.RevenueQuebecService;

import java.util.Scanner;

public class TaxwiseVue {

    public static void calculTaxeVue() {

        //Lire le revenu à partir de la console
        Scanner scan = new Scanner(System.in);
        System.out.println("Entrer votre revenu annuel : ");
        String revenu = scan.next();
        double montant = Double.parseDouble(revenu);

        /******************1-Creation des DAO **************/

        /*1-DAO de TrancheRevenu pour aller chercher les tranches d une autorite fiscale*/
        //ITranchesRevenuDAO daoTaux = new TranchesRevenuDAO_JPA();
        //ITranchesRevenuDAO daoTaux = new TranchesRevenuDAO_InMemory();
        ITranchesRevenuDAO daoTaux = new TranchesRevenuDAO_JDBC();

        /*2-DAO de AutoriteFiscale pour aller chercher le seuil */
        //IAutoriteFiscaleDAO daoSeuil=new AutoriteFiscaleDAO_InMemory();
        // IAutoriteFiscaleDAO daoSeuil=new AutoriteFiscaleDAO_JPA();
        IAutoriteFiscaleDAO daoSeuil = new AutoriteFiscaleDAO_JDBC();

        /******2-Passer les DAO aux services pour calculer les taxes***********/

        //service RevenueCanada pour calculer la taxe du revenu deu Canada
        RevenueCanadaService calculCa = new RevenueCanadaService(daoTaux, daoSeuil);
        double taxeCa = calculCa.calculTaxe(montant);
        System.out.println("La taxe du Canada " + taxeCa+" CAD");

        //service RevenueQuebec pour calculer la taxe du revenu deu Quebec
        RevenueQuebecService calculQc = new RevenueQuebecService(daoTaux, daoSeuil);
        double taxeQC = calculQc.calculTaxe(montant);
        System.out.println("La taxe du Quebec " + taxeQC+" CAD");
    }
}

