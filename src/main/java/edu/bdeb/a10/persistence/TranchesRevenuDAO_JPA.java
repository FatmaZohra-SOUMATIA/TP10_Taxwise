package edu.bdeb.a10.persistence;

import edu.bdeb.a10.model.TranchesRevenu;
import edu.bdeb.a10.view.TaxwiseVue;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.mariadb.jdbc.export.HaMode;
import org.mariadb.jdbc.Driver;

import java.util.List;

public class TranchesRevenuDAO_JPA {
    Taxwise_PersistenceUnitinfo taxwise_pui = new Taxwise_PersistenceUnitinfo();
    EntityManagerFactory emf = new HibernatePersistenceProvider()
            .createEntityFactory(taxwise_pui, new HaMode());
    EntityManager em = emf.createEntityManager().createEntityM();


    public List<TranchesRevenu> trouverTranchesParAutorite(String autorite_id) {
        return this.em.find(TranchesRevenu.class, autorite_id);
    }
}
