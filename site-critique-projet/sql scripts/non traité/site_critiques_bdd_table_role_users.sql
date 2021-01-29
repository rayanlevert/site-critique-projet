
-- --------------------------------------------------------

--
-- Structure de la table `role_users`
--

DROP TABLE IF EXISTS `role_users`;
CREATE TABLE IF NOT EXISTS `role_users` (
  `roles_id` bigint(20) NOT NULL,
  `users_id` bigint(20) NOT NULL,
  KEY `FKipeyaf3dve9njdrl1t23ndidv` (`users_id`),
  KEY `FKtknfu7wu682rywhjmmbmtex1p` (`roles_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
