package edu.bdeb.a10.model;

import jakarta.persistence.*;

@Entity
@NamedQuery(name = "TROUVER_TRANCHE_REVENU_PAR_NOM_AUTORITE", query =

        "SELECT tr " +
                "FROM TranchesRevenu tr " +
                "JOIN AutoriteFiscale af ON tr.id = af.id " +
                "WHERE af.nom LIKE :nom AND tr.trancheMin <= :revenu")

public class TranchesRevenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="tranche_min")
    private double trancheMin;

    @Column(name="tranche_max")
    private double trancheMax;

    @Column(name="taux_imposition")
    private double tauxImposition;

    // Constructeurs

    public TranchesRevenu() {
    }

    public TranchesRevenu(int id,  double trancheMin, double trancheMax, double tauxImposition) {
        this.id = id;

        this.trancheMin = trancheMin;
        this.trancheMax = trancheMax;
        this.tauxImposition = tauxImposition;
    }
    public TranchesRevenu(double trancheMin, double trancheMax, double tauxImposition) {
        this.trancheMin = trancheMin;
        this.trancheMax = trancheMax;
        this.tauxImposition = tauxImposition;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTrancheMin() {
        return trancheMin;
    }

    public void setTrancheMin(double trancheMin) {
        this.trancheMin = trancheMin;
    }

    public double getTrancheMax() {
        return trancheMax;
    }

    public void setTrancheMax(Double trancheMax) {
        this.trancheMax = trancheMax;
    }

    public double getTauxImposition() {
        return tauxImposition;
    }

    public void setTauxImposition(double tauxImposition) {
        this.tauxImposition = tauxImposition;
    }
}

