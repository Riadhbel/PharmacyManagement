-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 10 jan. 2023 à 21:01
-- Version du serveur : 10.4.24-MariaDB
-- Version de PHP : 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `pharmacie`
--

-- --------------------------------------------------------

--
-- Structure de la table `achats`
--

CREATE TABLE `achats` (
  `AchatsID` int(11) NOT NULL,
  `Fournisseur` varchar(50) NOT NULL,
  `Lot` varchar(50) NOT NULL,
  `PrixAchats` int(50) NOT NULL,
  `Produit` varchar(50) NOT NULL,
  `PrixVente` int(11) NOT NULL,
  `Qte` int(40) NOT NULL,
  `Famille` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `achats`
--

INSERT INTO `achats` (`AchatsID`, `Fournisseur`, `Lot`, `PrixAchats`, `Produit`, `PrixVente`, `Qte`, `Famille`) VALUES
(1, 'A', 'produit A', 50, 'paracetamol', 100, 0, ''),
(2, 'B', 'type 1 ', 60, 'What', 80, 0, ''),
(3, 'kgk', 'hkln', 40, 'i', 90, 0, ''),
(4, 'k2', 'wemp', 32, 'wfwe', 34, 44, 'wfm');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id_client` int(11) NOT NULL,
  `nom_client` varchar(50) NOT NULL,
  `prenom_client` varchar(50) NOT NULL,
  `adresse_client` varchar(50) DEFAULT NULL,
  `num_tel` int(11) DEFAULT NULL,
  `num_assurance` int(30) DEFAULT NULL,
  `age_client` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id_client`, `nom_client`, `prenom_client`, `adresse_client`, `num_tel`, `num_assurance`, `age_client`) VALUES
(2, 'Adnane', 'Zakaria', '77 Kadous', NULL, NULL, NULL),
(3, 'BNKR', 'HALOM', 'BLIDA', NULL, 5, NULL),
(5, 'belarbi', 'ryad', 'ceazfgoiezhn', 23121, 231341, 213),
(6, 'BNKR', 'HALOM', 'BLIDA', 0, 5, 0),
(7, 'Adnane', 'Zakaria', '77 Kadous', 0, 0, 0),
(8, 'BELARBI', 'Riadh', '16 Rue Tixeraine', 557575757, 0, 0),
(9, 'ryad', 'belarbi', 'ceazfgoiezhn', 2121, 231341, 55555),
(12, 'BELARBI', 'Riadh', '16 Rue Tixeraine', 557575757, 0, 0),
(15, 'BELARBI', 'Riadh', '16 Rue Tixeraine', 557575757, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `id_produit` int(11) NOT NULL,
  `nom_produit` varchar(50) NOT NULL,
  `lot_produit` varchar(50) NOT NULL,
  `pachat_produit` int(11) NOT NULL,
  `pvente_produit` int(11) NOT NULL,
  `qte_produit` int(11) NOT NULL,
  `famille_produit` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`id_produit`, `nom_produit`, `lot_produit`, `pachat_produit`, `pvente_produit`, `qte_produit`, `famille_produit`) VALUES
(1, 'Paracetamol', 'm22', 45, 60, 30, 'Médicament'),
(2, 'Aspegic', 'g99', 125, 175, 30, 'Medicament'),
(3, 'Alcool chirurgical', 'h55', 40, 80, 50, 'Cosmetique');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `idUser` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `typeUser` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`idUser`, `username`, `password`, `typeUser`) VALUES
(1, 'admin', 'admin', 1),
(2, 'manager1', '1234', 2),
(3, 'vendeur1', '0000', 3),
(6, 'vendeur1', '0000', 6);

-- --------------------------------------------------------

--
-- Structure de la table `vente`
--

CREATE TABLE `vente` (
  `id_vente` int(11) NOT NULL,
  `date_vente` date NOT NULL,
  `totalpayer_vente` int(11) NOT NULL,
  `client_vente` varchar(50) NOT NULL,
  `user_vente` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `achats`
--
ALTER TABLE `achats`
  ADD PRIMARY KEY (`AchatsID`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id_client`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id_produit`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`idUser`);

--
-- Index pour la table `vente`
--
ALTER TABLE `vente`
  ADD PRIMARY KEY (`id_vente`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `achats`
--
ALTER TABLE `achats`
  MODIFY `AchatsID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `id_client` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `id_produit` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `idUser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `vente`
--
ALTER TABLE `vente`
  MODIFY `id_vente` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
