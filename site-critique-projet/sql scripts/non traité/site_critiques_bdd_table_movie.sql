
-- --------------------------------------------------------

--
-- Structure de la table `movie`
--

DROP TABLE IF EXISTS `movie`;
CREATE TABLE IF NOT EXISTS `movie` (
  `actors` varchar(1000) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `genre` varchar(1000) DEFAULT NULL,
  `nationality` varchar(50) DEFAULT NULL,
  `realisator` varchar(1000) DEFAULT NULL,
  `synopsys` varchar(10000) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
