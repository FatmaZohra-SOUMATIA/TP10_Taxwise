package edu.bdeb.a10.persistence;

import edu.bdeb.a10.model.TranchesRevenu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;


import java.util.HashMap;
import java.util.List;

public class TranchesRevenuDAO_JPA implements ITranchesRevenuDAO {
    EntityManagerFactory emf;
    EntityManager em;

    public TranchesRevenuDAO_JPA() {
        Taxwise_PersistenceUnitInfo taxwise_pui = new Taxwise_PersistenceUnitInfo();
        this.emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(taxwise_pui, new HashMap());
        this.em = emf.createEntityManager();
    }
//    public List<TranchesRevenu> trouverTranchesParAutorite(String autorite_id) {
//        return this.em.find(TranchesRevenu.class, autorite_id);
//    }

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
