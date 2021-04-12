-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Temps de generació: 12-04-2021 a les 21:22:43
-- Versió del servidor: 10.4.18-MariaDB
-- Versió de PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de dades: `smartpianoa8`
--

-- --------------------------------------------------------

--
-- Estructura de la taula `estadistiques`
--

CREATE TABLE `estadistiques` (
  `Hora` time NOT NULL,
  `NumCançons` int(255) DEFAULT 0,
  `NumMinuts` int(255) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Bolcament de dades per a la taula `estadistiques`
--

INSERT INTO `estadistiques` (`Hora`, `NumCançons`, `NumMinuts`) VALUES
('07:00:00', 3, 24),
('08:00:00', 4, 20),
('14:00:00', 6, 13),
('16:00:00', 2, 5);

-- --------------------------------------------------------

--
-- Estructura de la taula `playlist`
--

CREATE TABLE `playlist` (
  `Nom` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  `IdPlayList` int(255) NOT NULL,
  `NomUsuari` varchar(30) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Bolcament de dades per a la taula `playlist`
--

INSERT INTO `playlist` (`Nom`, `IdPlayList`, `NomUsuari`) VALUES
('la meva primera playlist 1', 1, 'elTeuPare'),
('la meva segona playlist', 2, 'joan123');

-- --------------------------------------------------------

--
-- Estructura de la taula `song`
--

CREATE TABLE `song` (
  `idSong` int(255) NOT NULL,
  `NumReproduccions` int(255) NOT NULL,
  `Nom` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `Autor` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `Duracio` time NOT NULL,
  `DataEnregistrament` date NOT NULL,
  `Directori` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  `isPublic` tinyint(1) NOT NULL,
  `NomUsuari` varchar(30) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Bolcament de dades per a la taula `song`
--

INSERT INTO `song` (`idSong`, `NumReproduccions`, `Nom`, `Autor`, `Duracio`, `DataEnregistrament`, `Directori`, `isPublic`, `NomUsuari`) VALUES
(1, 3, 'canco1', 'autor1', '00:02:45', '2011-04-09', 'C:\\user', 1, 'bertugarangou'),
(2, 4, 'canco2', 'autor2', '00:02:14', '2001-04-20', 'C:\\user', 1, 'elTeuPare'),
(3, 5, 'canco privada 1', 'autor privat 1', '00:01:45', '2018-04-18', 'C:\\user', 0, 'elTeuPare');

-- --------------------------------------------------------

--
-- Estructura de la taula `songplaylist`
--

CREATE TABLE `songplaylist` (
  `idSong` int(255) NOT NULL,
  `IdPlayList` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Bolcament de dades per a la taula `songplaylist`
--

INSERT INTO `songplaylist` (`idSong`, `IdPlayList`) VALUES
(1, 1),
(1, 1);

-- --------------------------------------------------------

--
-- Estructura de la taula `usuari`
--

CREATE TABLE `usuari` (
  `NomUsuari` varchar(30) COLLATE latin1_spanish_ci NOT NULL,
  `Email` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  `Contrassenya` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  `tipus` varchar(30) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Bolcament de dades per a la taula `usuari`
--

INSERT INTO `usuari` (`NomUsuari`, `Email`, `Contrassenya`, `tipus`) VALUES
('bertugarangou', 'albertgarangou@emporda.cat', 'pallaringa', ''),
('elTeuPare', 'HoLa@batutDeXocolata.cat', 'hotMenArround1km', ''),
('joan123', 'joan123@gmail.com', 'contrassenyacaca', ''),
('mvalsells', 'marcvalsells@gmail.com', 'contrassenya123', '');

--
-- Índexs per a les taules bolcades
--

--
-- Índexs per a la taula `estadistiques`
--
ALTER TABLE `estadistiques`
  ADD PRIMARY KEY (`Hora`);

--
-- Índexs per a la taula `playlist`
--
ALTER TABLE `playlist`
  ADD PRIMARY KEY (`IdPlayList`),
  ADD UNIQUE KEY `NomUsuari_2` (`NomUsuari`),
  ADD KEY `NomUsuari` (`NomUsuari`),
  ADD KEY `NomUsuari_3` (`NomUsuari`);

--
-- Índexs per a la taula `song`
--
ALTER TABLE `song`
  ADD PRIMARY KEY (`idSong`),
  ADD KEY `NomUsuari` (`NomUsuari`);

--
-- Índexs per a la taula `songplaylist`
--
ALTER TABLE `songplaylist`
  ADD KEY `idSong` (`idSong`,`IdPlayList`),
  ADD KEY `IdPlayList` (`IdPlayList`);

--
-- Índexs per a la taula `usuari`
--
ALTER TABLE `usuari`
  ADD PRIMARY KEY (`NomUsuari`);

--
-- AUTO_INCREMENT per les taules bolcades
--

--
-- AUTO_INCREMENT per la taula `playlist`
--
ALTER TABLE `playlist`
  MODIFY `IdPlayList` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la taula `song`
--
ALTER TABLE `song`
  MODIFY `idSong` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restriccions per a les taules bolcades
--

--
-- Restriccions per a la taula `playlist`
--
ALTER TABLE `playlist`
  ADD CONSTRAINT `playlist_ibfk_1` FOREIGN KEY (`NomUsuari`) REFERENCES `usuari` (`NomUsuari`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restriccions per a la taula `song`
--
ALTER TABLE `song`
  ADD CONSTRAINT `song_ibfk_1` FOREIGN KEY (`NomUsuari`) REFERENCES `usuari` (`NomUsuari`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restriccions per a la taula `songplaylist`
--
ALTER TABLE `songplaylist`
  ADD CONSTRAINT `songplaylist_ibfk_1` FOREIGN KEY (`IdPlayList`) REFERENCES `playlist` (`IdPlayList`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `songplaylist_ibfk_2` FOREIGN KEY (`idSong`) REFERENCES `song` (`idSong`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
