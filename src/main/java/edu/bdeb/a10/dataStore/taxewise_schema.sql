CREATE TABLE AutoriteFiscale (
                                 id INT AUTO_INCREMENT PRIMARY KEY,
                                 nom VARCHAR(100) NOT NULL,
                                 seuil_exonere DECIMAL(10, 2) NOT NULL
);

CREATE TABLE TranchesRevenu (
                                id INT AUTO_INCREMENT PRIMARY KEY,
                                autorite_fiscale_id INT,
                                tranche_min DECIMAL(10, 2),
                                tranche_max DECIMAL(10, 2),
                                taux_imposition DECIMAL(5, 2),
                                FOREIGN KEY (autorite_fiscale_id) REFERENCES AutoriteFiscale(id)
);
