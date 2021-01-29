
--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `FKrxy204bw6ki78smmg266m6ggd` FOREIGN KEY (`id`) REFERENCES `article` (`id`);

--
-- Contraintes pour la table `commentary`
--
ALTER TABLE `commentary`
  ADD CONSTRAINT `FKmt8mfvt56l7jnhuhadgau7fpx` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKp16awc53outhn00t18welvqxr` FOREIGN KEY (`review_id_review`) REFERENCES `review` (`id_review`);

--
-- Contraintes pour la table `game`
--
ALTER TABLE `game`
  ADD CONSTRAINT `FK3cs02617hbbs69wfg56q3p2y8` FOREIGN KEY (`id`) REFERENCES `article` (`id`);

--
-- Contraintes pour la table `movie`
--
ALTER TABLE `movie`
  ADD CONSTRAINT `FKhhpj09wlnyk2evhgwtqgdlh52` FOREIGN KEY (`id`) REFERENCES `article` (`id`);

--
-- Contraintes pour la table `review`
--
ALTER TABLE `review`
  ADD CONSTRAINT `FK8klm4xeeoxyah8iy90xt2svgp` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`),
  ADD CONSTRAINT `FKiyf57dy48lyiftdrf7y87rnxi` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `role_users`
--
ALTER TABLE `role_users`
  ADD CONSTRAINT `FKipeyaf3dve9njdrl1t23ndidv` FOREIGN KEY (`users_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKtknfu7wu682rywhjmmbmtex1p` FOREIGN KEY (`roles_id`) REFERENCES `role` (`id`);
