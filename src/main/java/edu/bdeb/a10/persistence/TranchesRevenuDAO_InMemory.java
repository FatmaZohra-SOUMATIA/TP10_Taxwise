package edu.bdeb.a10.persistence;

import edu.bdeb.a10.dataStore.InMemoryRepository;
import edu.bdeb.a10.model.TranchesRevenu;

import java.util.ArrayList;
import java.util.List;

public class TranchesRevenuDAO_InMemory implements ITranchesRevenuDAO {

    InMemoryRepository db;

    public TranchesRevenuDAO_InMemory() {
        this.db = InMemoryRepository.getInstance();
    }

    @Override
    // Recherche les tranches de revenu pour une autorité fiscale donnée et un montant donné.
    public List<TranchesRevenu> rechercheTaux(String autorite, double montant) {
        AutoriteFiscaleDAO_InMemory dao = new AutoriteFiscaleDAO_InMemory();
        List<TranchesRevenu> listTranches = new ArrayList<TranchesRevenu>();
        int id = dao.rechercheIdParAutorite(autorite);
        for (TranchesRevenu tr : this.db.tranchesRevenu) {
            if (tr.getId() == id) {
                if (tr.getTrancheMin() < montant) {
                    listTranches.add(tr);
                }
            }
        }

        return listTranches;
    }

    // Ajoute une nouvelle tranche de revenu dans la base de données.
    @Override
    public void ajouterTranchesRevenu(TranchesRevenu tranche) {
        this.db.tranchesRevenu.add(tranche);
    }

    //Modifie une tranche de revenu existante dans la base de données.
    @Override
    public void modifierTranchesRevenu(TranchesRevenu tranche) {

    }

    // Supprime toutes les tranches de revenu pour une autorité fiscale donnée.

    @Override
    public void supprimerTranchesRevenuAutorite(int id) {
        for (TranchesRevenu tr : this.db.tranchesRevenu) {
            if (tr.getId() == id) {
                this.db.tranchesRevenu.remove(tr);
            }
      }

    }


}
