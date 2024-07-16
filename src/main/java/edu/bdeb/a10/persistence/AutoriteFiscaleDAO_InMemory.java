package edu.bdeb.a10.persistence;

import edu.bdeb.a10.dataStore.InMemoryRepository;
import edu.bdeb.a10.model.AutoriteFiscale;

public class AutoriteFiscaleDAO_InMemory implements IAutoriteFiscaleDAO {
    InMemoryRepository db;
    // Constructeur qui initialise la base de données en mémoire
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
    public int rechercheIdParAutorite(String autorite) {
        for(AutoriteFiscale af : this.db.autoritesFiscale){
            if (af.getNom().equals(autorite)){
                return af.getId();
            }
        }
        return 0;
    }
    @Override
    public void ajouterAutorite(AutoriteFiscale autoriteFiscale) {
        db.autoritesFiscale.add(autoriteFiscale);

    }

    @Override
    public void modifierSeuilAutorite(int id, double seuil) {
        for (AutoriteFiscale af : this.db.autoritesFiscale){
            if (af.getId() == id){
                af.setSeuilExonere(seuil);
            }
        }

    }

    @Override
    public void supprimerAutorite(int id) {
        for (AutoriteFiscale af : this.db.autoritesFiscale){
            if (af.getId() == id){
                db.autoritesFiscale.remove(af);
            }
        }

    }
}
