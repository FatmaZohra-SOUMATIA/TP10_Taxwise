package edu.bdeb.a10.dataStore;

import edu.bdeb.a10.model.AutoriteFiscale;
import edu.bdeb.a10.model.TranchesRevenu;

import java.util.ArrayList;
import java.util.List;

// Cette classe aide à émuler la base de données (Singleton)
public class InMemoryRepository {
    // Étape 2 : Déclaration de l'instance unique de la classe
    public static InMemoryRepository datastore = null;

    // Listes pour stocker les autorités fiscales et les tranches de revenu
    public List<AutoriteFiscale> autoritesFiscale;
    public List<TranchesRevenu> tranchesRevenu;

    // Étape 1 : Rendre le constructeur privé pour empêcher l'instanciation externe
    private InMemoryRepository() {
        autoritesFiscale = new ArrayList<AutoriteFiscale>();
        tranchesRevenu = new ArrayList<TranchesRevenu>();

        // Ajout des autorités fiscales avec des valeurs initiales
        AutoriteFiscale autoriteFiscaleCA = new AutoriteFiscale(1, "Canada", 15000);
        this.autoritesFiscale.add(autoriteFiscaleCA);

        AutoriteFiscale autoriteFiscaleQC = new AutoriteFiscale(2, "Québec", 17000);
        this.autoritesFiscale.add(autoriteFiscaleQC);

        // Ajout des tranches de revenu pour chaque autorité fiscale
        this.tranchesRevenu.add(new TranchesRevenu(1, 0, 55867, 15));
        this.tranchesRevenu.add(new TranchesRevenu(1, 55867, 111733, 20.5));
        this.tranchesRevenu.add(new TranchesRevenu(1, 111733, 173205, 26));
        this.tranchesRevenu.add(new TranchesRevenu(1, 173205, 246752, 29));
        this.tranchesRevenu.add(new TranchesRevenu(1, 246752, 999999, 33));

        this.tranchesRevenu.add(new TranchesRevenu(2, 0, 51780, 14));
        this.tranchesRevenu.add(new TranchesRevenu(2, 51780, 103545, 19));
        this.tranchesRevenu.add(new TranchesRevenu(2, 103545, 126000, 24));
        this.tranchesRevenu.add(new TranchesRevenu(2, 126000, 999999, 25.75));

    }

    // Étape 3 : getInstance pour récupérer l'instance unique
    public static InMemoryRepository getInstance() {
        // Si l'instance n'a pas encore été créée, créer une nouvelle instance
        if (InMemoryRepository.datastore == null)
            InMemoryRepository.datastore = new InMemoryRepository();
        // Retourner l'instance unique
        return InMemoryRepository.datastore;
    }
}
