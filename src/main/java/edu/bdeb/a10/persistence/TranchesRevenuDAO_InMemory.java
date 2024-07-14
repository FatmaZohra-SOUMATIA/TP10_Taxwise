package edu.bdeb.a10.persistence;

import edu.bdeb.a10.model.TranchesRevenu;

import java.util.List;

public class TranchesRevenuDAO_InMemory implements ITranchesRevenuDAO{

@Override
    // Recherche les tranches de revenu pour une autorité fiscale donnée et un montant donné.
public List<TranchesRevenu> rechercheTaux(String autorite, double montant){
    return List.of();
}

    // Ajoute une nouvelle tranche de revenu dans la base de données.
    @Override
    public void ajouterTranchesRevenu(TranchesRevenu tranche){

    }

    //Modifie une tranche de revenu existante dans la base de données.
    @Override
    public int modifierTranchesRevenu(TranchesRevenu tranche){
        return 0;
    }

    // Supprime toutes les tranches de revenu pour une autorité fiscale donnée.

    @Override
    public int supprimerTranchesRevenuAutorite(String autorite){
        return 0;
    }




}
