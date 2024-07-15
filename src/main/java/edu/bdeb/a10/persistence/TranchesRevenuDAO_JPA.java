package edu.bdeb.a10.persistence;

import edu.bdeb.a10.model.TranchesRevenu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
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

    @Override
    public List<TranchesRevenu> rechercheTaux(String autorite, double montant) {
        this.em.getTransaction().begin();
        Query qurey=this.em.createNamedQuery("TROUVER_TRANCHE_REVENU_PAR_NOM_AUTORITE", TranchesRevenu.class);
        qurey.setParameter("nom", "%"+autorite);
        qurey.setParameter("revenu", montant);
        List<TranchesRevenu> tranchesRevenus=qurey.getResultList();
        this.em.getTransaction().commit();
        return tranchesRevenus;

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
    public void modifierTranchesRevenu(TranchesRevenu tranchesRevenu) {

    }

    @Override
    public void supprimerTranchesRevenuAutorite(int id) {
        EntityTransaction transaction = this.em.getTransaction();
        try {
            transaction.begin();
            TranchesRevenu tranche = this.em.find(TranchesRevenu.class, id);
            this.em.remove(tranche);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace(); // Handle or log the exception as needed
        }
    }
    public void close(){
        this.em.close();
        this.emf.close();
    }
}


