package edu.bdeb.a10.dataStore;

import edu.bdeb.a10.model.AutoriteFiscale;
import edu.bdeb.a10.model.TranchesRevenu;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

// this class helps in emulating the database
public class InMemoryRepository {
    //Step 2
    public static InMemoryRepository datastore=null;

    public List<AutoriteFiscale> sueilAutorite;
    public List<TranchesRevenu> tauxTrancheRevenu;

    // Step 1 : make constructor private
    private InMemoryRepository(){
        sueilAutorite = new ArrayList<AutoriteFiscale>();
        tauxTrancheRevenu = new ArrayList<TranchesRevenu>();

        AutoriteFiscale autoriteFiscaleCA = new AutoriteFiscale(1,"Canada",15000);
        this.sueilAutorite.add(autoriteFiscaleCA);

        AutoriteFiscale autoriteFiscaleQC = new AutoriteFiscale(2,"Québec",17000);
        this.sueilAutorite.add(autoriteFiscaleQC);



        tauxTrancheRevenu.add(new TranchesRevenu(1,0,55867,15));
        tauxTrancheRevenu.add(new TranchesRevenu(1,55867,111733,20.5));
        tauxTrancheRevenu.add(new TranchesRevenu(1,111733,173205,26));
        tauxTrancheRevenu.add(new TranchesRevenu(1,173205,246752,29));
        tauxTrancheRevenu.add(new TranchesRevenu(1,246752,999999,33));

        tauxTrancheRevenu.add(new TranchesRevenu(2,0,51780,14));
        tauxTrancheRevenu.add(new TranchesRevenu(2,51780,103545,19));
        tauxTrancheRevenu.add(new TranchesRevenu(2,103545,126000,24));
        tauxTrancheRevenu.add(new TranchesRevenu(2,126000,999999,25.75));

    }

    //Step 3: getInstance to retrieve the unique instance
    public static InMemoryRepository getInstance() {
        if(InMemoryRepository.datastore==null)
            InMemoryRepository.datastore = new InMemoryRepository();
        return InMemoryRepository.datastore;
    }
}
