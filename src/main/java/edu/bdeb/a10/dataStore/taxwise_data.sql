-- Insertion des données pour l'autorité fiscale
INSERT INTO AutoriteFiscale (nom, seuil_exonere) VALUES
                                                     ('Agence du revenu du Québec', 17000.00),
                                                     ('Agence du revenu du Canada', 15000.00);

-- Récupération des IDs générés automatiquement pour les autorités fiscales
SELECT id INTO @id_quebec FROM AutoriteFiscale WHERE nom = 'Agence du revenu du Québec';
SELECT id INTO @id_canada FROM AutoriteFiscale WHERE nom = 'Agence du revenu du Canada';

-- Insertion des données pour les tranches de revenu du Québec
INSERT INTO TranchesRevenu (autorite_fiscale_id, tranche_min, tranche_max, taux_imposition) VALUES
                                                                                                (@id_quebec, 0.00, 51780.00, 14.00),
                                                                                                (@id_quebec, 51780.01, 103545.00, 19.00),
                                                                                                (@id_quebec, 103545.01, 126000.00, 24.00),
                                                                                                (@id_quebec, 126000.01, 999999.00, 25.75);

-- Insertion des données pour les tranches de revenu du Canada
INSERT INTO TranchesRevenu (autorite_fiscale_id, tranche_min, tranche_max, taux_imposition) VALUES
                                                                                                (@id_canada, 0.00, 55867.00, 15.00),
                                                                                                (@id_canada, 55867.01, 111733.00, 20.50),
                                                                                                (@id_canada, 111733.01, 173205.00, 26.00),
                                                                                                (@id_canada, 173205.01, 246752.00, 29.00),
                                                                                                (@id_canada, 246752.01, 999999.00, 33.00);