
-- --------------------------------------------------------

--
-- Structure de la table `game`
--

DROP TABLE IF EXISTS `game`;
CREATE TABLE IF NOT EXISTS `game` (
  `developer` varchar(255) DEFAULT NULL,
  `genre` varchar(255) NOT NULL,
  `platform` varchar(255) DEFAULT NULL,
  `publisher` varchar(255) DEFAULT NULL,
  `resume` text,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
