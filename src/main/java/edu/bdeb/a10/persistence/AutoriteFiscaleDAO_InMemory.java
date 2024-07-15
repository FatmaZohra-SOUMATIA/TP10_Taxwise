package edu.bdeb.a10.persistence;

import edu.bdeb.a10.dataStore.InMemoryRepository;
import edu.bdeb.a10.model.AutoriteFiscale;

public class AutoriteFiscaleDAO_InMemory implements IAutoriteFiscaleDAO {
    InMemoryRepository db;
    public AutoriteFiscaleDAO_InMemory() {
        this.db = InMemoryRepository.getInstance();
    }
    @Override

    public double rechercheSeuil(String autorite) {
        for(AutoriteFiscale af : this.db.autoritesFiscale){
            if (af.getNom().equals(autorite)){
                return af.getSeuilExonere();
            }
        }
        return 0;
    }
    public int rechercheIdParAtotorite(String autorite) {
        for(AutoriteFiscale af : this.db.autoritesFiscale){
            if (af.getNom().equals(autorite)){
                return af.getId();
            }
        }
        return 0;
    }
    @Override
    public void ajouterAutorite(AutoriteFiscale autoriteFiscale) {

    }

    @Override
    public void modifierSeuilAutorite(int id, double seuil) {

    }

    @Override
    public void supprimerAutorite(int id) {

    }
}
/*




    // connect to database to load the rate
    public double find(Currency from, Currency to) {
        System.out.println("\nRetrieving data from memory...");
        for(ConversionRate rate : this.db.rates)
            if(rate.getFrom().getName().equalsIgnoreCase(from.getName()) &&
                    rate.getTo().getName().equalsIgnoreCase(to.getName()))
                return rate.getRate();
        return 0.0;
    }
 */