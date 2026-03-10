CREATE TYPE marque_enum AS ENUM ('FORD', 'GMC', 'DODGE');

CREATE TYPE modele_enum AS ENUM ('RANGER', 'EVEREST', 'YUKON', 'RAM');

CREATE TABLE Modele_voiture (
id INT PRIMARY KEY,
marque marque_enum,
modele modele_enum
);

CREATE TABLE Mecanicien (
id INT PRIMARY KEY,
nom VARCHAR(100),
marque marque_enum
);

CREATE TABLE Reparation (
id INT PRIMARY KEY,
id_mecanicien INT,
id_modele_voiture INT,
cout INT,
FOREIGN KEY (id_mecanicien) REFERENCES Mecanicien(id),
FOREIGN KEY (id_modele_voiture) REFERENCES Modele_voiture(id)
);



SELECT m.nom AS nom_mecanicien,
       SUM(r.cout) AS cout_total
FROM reparation r
JOIN mecanicien m ON r.id_mecanicien = m.id
GROUP BY m.nom
ORDER BY SUM(r.cout) ASC
LIMIT 1;



SELECT mv.marque, m.nom ,
SUM(r.cout) AS cout_reparation
FROM reparation r
JOIN mecanicien m ON r.id_mecanicien = m.id
JOIN modele_voiture mv ON r.id_modele_voiture = mv.id
GROUP BY mv.marque,m.nom;



