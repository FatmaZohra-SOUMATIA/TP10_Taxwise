package edu.bdeb.a10.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="TranchesRevenu")
public class TranchesRevenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = autorite_fiscale_id)
    private int autoriteFiscaleId;
    @Column(name=tranche_min)
    private double trancheMin;
    @Column(name=tranche_max)
    private double trancheMax;
    @Column(name=taux_imposition)
    private double tauxImposition;

    // Constructeurs

    public TranchesRevenu() {
    }

    public TranchesRevenu(int id, int autoriteFiscaleId, double trancheMin, double trancheMax, double tauxImposition) {
        this.id = id;
        this.autoriteFiscaleId = autoriteFiscaleId;
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

    public int getAutoriteFiscaleId() {
        return autoriteFiscaleId;
    }

    public void setAutoriteFiscaleId(int autoriteFiscaleId) {
        this.autoriteFiscaleId = autoriteFiscaleId;
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

