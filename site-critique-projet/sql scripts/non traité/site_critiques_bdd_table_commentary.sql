
-- --------------------------------------------------------

--
-- Structure de la table `commentary`
--

DROP TABLE IF EXISTS `commentary`;
CREATE TABLE IF NOT EXISTS `commentary` (
  `id_comment` bigint(20) NOT NULL AUTO_INCREMENT,
  `content_comment` text NOT NULL,
  `publish_date` datetime DEFAULT NULL,
  `review_id_review` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_comment`),
  KEY `FKp16awc53outhn00t18welvqxr` (`review_id_review`),
  KEY `FKmt8mfvt56l7jnhuhadgau7fpx` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
