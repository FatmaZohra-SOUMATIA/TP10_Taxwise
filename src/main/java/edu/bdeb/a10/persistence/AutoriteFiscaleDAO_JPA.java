package edu.bdeb.a10.persistence;

import edu.bdeb.a10.model.AutoriteFiscale;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.mariadb.jdbc.Driver;
import org.mariadb.jdbc.export.HaMode;

import java.util.List;

public class AutoriteFiscaleDAO_JPA {
    Taxwise_PersistenceUnitinfo taxwise_pui = new Taxwise_PersistenceUnitinfo();
    EntityManagerFactory emf = new HibernatePersistenceProvider()
            .createEntityFactory(taxwise_pui, new HaMode());
    EntityManager em = emf.createEntityManager().createEntityM();


    public AutoriteFiscale trouverTranchesParAutorite(String autorite_id) {
        return this.em.find(AutoriteFiscale.class, autorite_id);
    }
}
