
CREATE TABLE AutoriteFiscale (
                                 id INT PRIMARY KEY AUTO_INCREMENT,
                                 nom VARCHAR(255) NOT NULL,
                                 seuil_exonere DOUBLE
);



CREATE TABLE TranchesRevenu (
                                id INT PRIMARY KEY AUTO_INCREMENT,
                                tranche_min DOUBLE,
                                tranche_max DOUBLE,
                                taux_imposition DOUBLE,
                                autorite_fiscale_id INT,
                                FOREIGN KEY (autorite_fiscale_id) REFERENCES AutoriteFiscale(id) ON DELETE CASCADE
);
