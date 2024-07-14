package edu.bdeb.a10.persistence;

import edu.bdeb.a10.model.TranchesRevenu;

import java.util.List;

public class TranchesRevenuDAO_InMemory implements ITranchesRevenuDAO{
    @Override
    public List<TranchesRevenu> rechercheTaux(String autorite, double montant) {
        return List.of();
    }

    @Override
    public int ajouterTranchesRevenu(TranchesRevenu tranche) {
        return 0;
    }

    @Override
    public int modifierTranchesRevenu(TranchesRevenu tranche) {
        return 0;
    }

    @Override
    public int supprimerTranchesRevenuAutorite(String autorite) {
        return 0;
    }
}
