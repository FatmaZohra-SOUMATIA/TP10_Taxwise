package edu.bdeb.a10.persistence;

import edu.bdeb.a10.model.TranchesRevenu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.ArrayList;
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
//    public List<TranchesRevenu> rechercheTaux(String autorite, double montant) {
//        this.em.getTransaction().begin();
//        Query qurey=this.em.createNamedQuery("TROUVER_TRANCHE_REVENU_PAR_NOM_AUTORITE", TranchesRevenu.class);
//        qurey.setParameter("nom", "%"+autorite);
//        qurey.setParameter("revenu", montant);
//        List<TranchesRevenu> tranchesRevenus=qurey.getResultList();
//        this.em.getTransaction().commit();
//        return tranchesRevenus;
//
//    }


    public List<TranchesRevenu> rechercheTaux(String autorite, double montant) {
        String nativeQuery = "SELECT  tr.id, tr.tranche_min, tr.tranche_max, tr.taux_imposition, tr.autorite_fiscale_id FROM TranchesRevenu tr JOIN AutoriteFiscale af ON tr.autorite_fiscale_id = af.id WHERE af.nom LIKE ? AND tr.tranche_min <= ? ";
        this.em.getTransaction().begin();
        Query namedQuery = this.em.createNativeQuery(nativeQuery);
        namedQuery.setParameter(1, "%"+autorite);
        namedQuery.setParameter(2,montant);

        //List<TranchesRevenu> tranchesRevenus= namedQuery.getResultList();
        List<Object[]> results = namedQuery.getResultList();
        List<TranchesRevenu> listeTranches = new ArrayList<TranchesRevenu>();
        for (Object[] result : results) {
            TranchesRevenu tr = new TranchesRevenu();
            tr.setId((int) result[0]);
            tr.setTrancheMin((double) result[1]);
            tr.setTrancheMax((double) result[2]);
            tr.setTauxImposition((double) result[3]);


            listeTranches.add(tr);
        }

        this.em.getTransaction().commit();
        return listeTranches;

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


