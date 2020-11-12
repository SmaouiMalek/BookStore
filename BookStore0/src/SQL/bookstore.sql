-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 12 nov. 2020 à 15:12
-- Version du serveur :  10.4.14-MariaDB
-- Version de PHP : 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `bookstore`
--

-- --------------------------------------------------------

--
-- Structure de la table `book`
--

CREATE TABLE `book` (
  `Id` int(11) NOT NULL,
  `author` varchar(255) NOT NULL DEFAULT '',
  `title` varchar(255) NOT NULL DEFAULT '',
  `price` double NOT NULL DEFAULT 0,
  `releasedate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `book`
--

INSERT INTO `book` (`Id`, `author`, `title`, `price`, `releasedate`) VALUES
(1, 'victor', 'cosette', 123, '1970-01-01'),
(2, 'MELEK', 'SMAOUI', 123, '2020-02-02'),
(4, 'melek', 'java', 123, '1970-01-01'),
(6, 'ramzi', 'xml', 1234, '1970-01-01'),
(7, 'MALEK', 'MALEK', 231, '2020-10-23'),
(8, 'ahmed', 'td', 123, '1970-01-01'),
(9, 'sonia', 'sgbd', 1234, '1970-01-01'),
(11, 'sami', 'image', 123, '1970-01-01'),
(12, 'BERNARD LEE', 'HTML5', 132, '1970-01-01'),
(20, 'MALEK', 'MALEK', 123, '2020-01-23'),
(21, 'malek', 'orc', 123, '2020-01-22');

-- --------------------------------------------------------

--
-- Structure de la table `cmdline`
--

CREATE TABLE `cmdline` (
  `idline` int(11) NOT NULL,
  `id` int(11) NOT NULL DEFAULT 0,
  `price` varchar(255) DEFAULT NULL,
  `qty` varchar(255) DEFAULT NULL,
  `totalprice` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `cmdline`
--

INSERT INTO `cmdline` (`idline`, `id`, `price`, `qty`, `totalprice`) VALUES
(1, 7, '1234.0', '45', '55530.0'),
(2, 21, '123.0', '423', '52029.0'),
(3, 20, '123.0', '32', '3936.0'),
(4, 21, '123.0', '21', '2583.0'),
(5, 20, '123.0', '312', '38376.0'),
(6, 7, '231.0', '34', '7854.0'),
(7, 21, '123.0', '43', '5289.0'),
(9, 20, '123.0', '32', '3936.0');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `login` varchar(10) NOT NULL DEFAULT '',
  `pass` varchar(8) NOT NULL DEFAULT '',
  `name` varchar(10) DEFAULT NULL,
  `sname` varchar(10) DEFAULT NULL,
  `phone` varchar(12) DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`login`, `pass`, `name`, `sname`, `phone`) VALUES
('U001', '1234567', 'MELEK', 'SMAOUI', '56309010');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`Id`);

--
-- Index pour la table `cmdline`
--
ALTER TABLE `cmdline`
  ADD PRIMARY KEY (`idline`),
  ADD KEY `id` (`id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`login`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `book`
--
ALTER TABLE `book`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT pour la table `cmdline`
--
ALTER TABLE `cmdline`
  MODIFY `idline` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `cmdline`
--
ALTER TABLE `cmdline`
  ADD CONSTRAINT `cmdline_ibfk_1` FOREIGN KEY (`id`) REFERENCES `book` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
