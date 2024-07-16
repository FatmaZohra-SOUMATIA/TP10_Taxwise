package edu.bdeb.a10.persistence;

import edu.bdeb.a10.model.AutoriteFiscale;
import edu.bdeb.a10.model.TranchesRevenu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
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


    @Override
//    public double rechercheSeuil(String autorite) {
//        Query namedQuery =this.em.createNamedQuery("RECHERCHE_SEUIL_PAR_NOM", AutoriteFiscale.class);
//        namedQuery.setParameter("autorite", autorite);
//        return (double) namedQuery.getSingleResult();
//    }
    public double rechercheSeuil(String autorite) {
        String nativeQuery = "select seuil_exonere from AutoriteFiscale  where nom LIKE ?";
        Query namedQuery = this.em.createNativeQuery(nativeQuery);
        namedQuery.setParameter(1, "%" + autorite);
        return (double) namedQuery.getSingleResult();
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
            e.printStackTrace();
        }
    }

    @Override
    public void modifierSeuilAutorite(int id, double seuil) {
        EntityTransaction transaction = this.em.getTransaction();
        try {
            transaction.begin();
            AutoriteFiscale autorite = this.em.find(AutoriteFiscale.class, id);
            autorite.setSeuilExonere(seuil);
            // Met à jour l'entité TranchesRevenu
            this.em.merge(autorite);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public void supprimerAutorite(int id) {

        EntityTransaction transaction = this.em.getTransaction();
        try {
            transaction.begin();
            AutoriteFiscale autoriteFiscale = this.em.find(AutoriteFiscale.class, id);
            this.em.remove(autoriteFiscale);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void close() {
        this.em.close();
        this.emf.close();
    }
}
