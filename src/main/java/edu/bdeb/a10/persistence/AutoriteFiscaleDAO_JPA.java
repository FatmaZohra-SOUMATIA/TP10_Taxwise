package edu.bdeb.a10.persistence;

import edu.bdeb.a10.model.AutoriteFiscale;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;


public class AutoriteFiscaleDAO_JPA implements IAutoriteFiscaleDAO {

    EntityManagerFactory emf;
    EntityManager em;

    public AutoriteFiscaleDAO_JPA() {
        Taxwise_PersistenceUnitInfo taxwise_pui = new Taxwise_PersistenceUnitInfo();
        this.emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(taxwise_pui, new HashMap());
        this.em = emf.createEntityManager();
    }

    public AutoriteFiscale trouverTranchesParAutorite(String autorite_id) {
        return this.em.find(AutoriteFiscale.class, autorite_id);
    }

    @Override
    public double rechercheSeuil(String autorite) {
        return 0;
    }

    @Override
    public void ajouterAutorite(AutoriteFiscale autoriteFiscale) {
        EntityTransaction transaction = this.em.getTransaction();
        try {
            transaction.begin();
            this.em.persist(autoriteFiscale);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace(); // Handle or log the exception as needed
        }
    }

    @Override
    public int modifierSeuilAutorite(String autorite, double seuil) {
        return 0;
    }

    @Override
    public int supprimerAutorite(String autorite) {
        return 0;
    }

    public void close(){
        this.em.close();
        this.emf.close();
    }
}
