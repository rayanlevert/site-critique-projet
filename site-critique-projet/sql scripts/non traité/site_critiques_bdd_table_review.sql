
-- --------------------------------------------------------

--
-- Structure de la table `review`
--

DROP TABLE IF EXISTS `review`;
CREATE TABLE IF NOT EXISTS `review` (
  `id_review` bigint(20) NOT NULL AUTO_INCREMENT,
  `content_review` text NOT NULL,
  `note_review` int(11) NOT NULL,
  `publish_date` datetime DEFAULT NULL,
  `title_review` varchar(255) NOT NULL,
  `article_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_review`),
  KEY `FK8klm4xeeoxyah8iy90xt2svgp` (`article_id`),
  KEY `FKiyf57dy48lyiftdrf7y87rnxi` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
