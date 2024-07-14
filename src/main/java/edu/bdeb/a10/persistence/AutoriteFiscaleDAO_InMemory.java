package edu.bdeb.a10.persistence;

public class AutoriteFiscaleDAO_InMemory implements IAutoriteFiscaleDAO {

    @Override
    public double rechercheSeuil(String autorite) {
        return 0;
    }

    @Override
    public int ajouterAutorite(String autorite, double seuil) {
        return 0;
    }

    @Override
    public int modifierSeuilAutorite(String autorite, double seuil) {
        return 0;
    }

    @Override
    public int supprimerAutorite(String autorite) {
        return 0;
    }
}
