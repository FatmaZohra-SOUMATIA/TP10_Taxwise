package edu.bdeb.a10.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "AutoriteFiscale")
@NamedQuery(name="RECHERCHE_SEUIL_PAR_NOM",
        query="select a.seuilExonere from AutoriteFiscale a where a.nom =: autorite")

public class AutoriteFiscale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "seuil_exonere")
    private double seuilExonere;

    @OneToMany
    @JoinColumn(name = "autorite_fiscale_id")
    private List<TranchesRevenu> taux;

    // Constructeurs
    public AutoriteFiscale(int id, String nom, double seuilExonere) {
        this.id = id;
        this.nom = nom;
        this.seuilExonere = seuilExonere;
        this.taux = new ArrayList<TranchesRevenu>();
    }
    public AutoriteFiscale(String nom, double seuilExonere) {
                this.nom = nom;
        this.seuilExonere = seuilExonere;
        this.taux = new ArrayList<TranchesRevenu>();
    }
    public AutoriteFiscale() {
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getSeuilExonere() {
        return seuilExonere;
    }

    public void setSeuilExonere(double seuilExonere) {
        this.seuilExonere = seuilExonere;
    }

    public List<TranchesRevenu> getTaux() {
        return taux;
    }

    public void setTaux(List<TranchesRevenu> taux) {
        this.taux = taux;
    }
}

