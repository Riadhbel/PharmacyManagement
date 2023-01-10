-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 10, 2023 at 08:56 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pharmacie`
--

-- --------------------------------------------------------

--
-- Table structure for table `achats`
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
-- Dumping data for table `achats`
--

INSERT INTO `achats` (`AchatsID`, `Fournisseur`, `Lot`, `PrixAchats`, `Produit`, `PrixVente`, `Qte`, `Famille`) VALUES
(1, 'A', 'produit A', 50, 'paracetamol', 100, 0, ''),
(2, 'B', 'type 1 ', 60, 'What', 80, 0, ''),
(3, 'kgk', 'hkln', 40, 'i', 90, 0, ''),
(4, 'k2', 'wemp', 32, 'wfwe', 34, 44, 'wfm');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `achats`
--
ALTER TABLE `achats`
  ADD PRIMARY KEY (`AchatsID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `achats`
--
ALTER TABLE `achats`
  MODIFY `AchatsID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
