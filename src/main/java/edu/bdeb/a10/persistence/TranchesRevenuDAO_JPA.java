package edu.bdeb.a10.persistence;

import edu.bdeb.a10.model.TranchesRevenu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
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
    public void ajouterTranchesRevenu(TranchesRevenu tranche) {
        EntityTransaction transaction = this.em.getTransaction();
        try {
            transaction.begin();
            this.em.persist(tranche);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace(); // Handle or log the exception as needed
        }
    }

    @Override
    public int modifierTranchesRevenu(TranchesRevenu tranche) {
        return 0;
    }

    @Override
    public int supprimerTranchesRevenuAutorite(String autorite) {
        return 0;
    }
    public void close(){
        this.em.close();
        this.emf.close();
    }
}


