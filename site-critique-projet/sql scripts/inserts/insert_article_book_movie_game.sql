
-- --------------------------------------------------------

--
-- Structure de la table `article`
--
CREATE TABLE IF NOT EXISTS `article` (
  `discriminator` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creation_article_date` datetime DEFAULT NULL,
  `min_age` int(11) DEFAULT NULL,
  `publish_date` datetime NOT NULL,
  `title` varchar(255) NOT NULL,
  `valid` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/* Insertion dans article
discriminator	id	creation_article_date	min_age	publish_date	title	valid
 */
INSERT INTO `article` VALUES('book',0,'2021-01-29 00:00:00',12,'1954-07-29','Le seigneur des anneaux : La communauté de l’anneau',1);
INSERT INTO `article` VALUES('book',1,'2021-01-29 00:00:00',12,'1954-11-11','Le seigneur des anneaux : Les deux tours',1);
INSERT INTO `article` VALUES('book',2,'2021-01-29 00:00:00',12,'1955-10-20','Le seigneur des anneaux : Le retour du roi',1);

INSERT INTO `article` VALUES('movie',3,'2021-01-29 00:00:00',16,'2001-01-01','Le seigneur des anneaux : La communauté de l’anneau',1);
INSERT INTO `article` VALUES('movie',4,'2021-01-29 00:00:00',16,'2002-01-01','Le seigneur des anneaux : Les deux tours',1);
INSERT INTO `article` VALUES('movie',5,'2021-01-29 00:00:00',16,'2003-01-01','Le seigneur des anneaux : Le retour du roi',1);

INSERT INTO `article` VALUES('game',6,'2021-01-29 00:00:00',18,'2003-01-01','Le seigneur des anneaux : La communauté de l’anneau',1);
INSERT INTO `article` VALUES('game',7,'2021-01-29 00:00:00',18,'2002-01-01','Le seigneur des anneaux : Les deux tours',1);
INSERT INTO `article` VALUES('game',8,'2021-01-29 00:00:00',18,'2003-01-01','Le seigneur des anneaux : Le retour du roi',1);

/* Insertion dans book*/
INSERT INTO `book` VALUES('J.R.R Tolkien','Fantaisie',0);
INSERT INTO `book` VALUES('J.R.R Tolkien','Fantaisie',1);
INSERT INTO `book` VALUES('J.R.R Tolkien','Fantaisie',2);

/* insertion dans movie
actors 	duration 	genre 	nationality 	realisator 	synopsys 	id 
 */
INSERT INTO `movie` VALUES('Sean Astin, Elijah Wood, Viggo Mortensen',178,'Fantastique','américain, néo-zélandais','Peter Jackson',
"Dans ce chapitre de la trilogie, le jeune et timide Hobbit, Frodon Sacquet, hérite d'un anneau. Bien loin d'être une simple babiole, il s'agit de l'Anneau Unique, un instrument de pouvoir absolu qui permettrait à Sauron, le Seigneur des ténèbres, de régner sur la Terre du Milieu et de réduire en esclavage ses peuples. À moins que Frodon, aidé d'une Compagnie constituée de Hobbits, d'Hommes, d'un Magicien, d'un Nain, et d'un Elfe, ne parvienne à emporter l'Anneau à travers la Terre du Milieu jusqu'à la Crevasse du Destin, lieu où il a été forgé, et à le détruire pour toujours. Un tel périple signifie s'aventurer très loin en Mordor, les terres du Seigneur des ténèbres, où est rassemblée son armée d'Orques maléfiques... La Compagnie doit non seulement combattre les forces extérieures du mal mais aussi les dissensions internes et l'influence corruptrice qu'exerce l'Anneau lui-même.
L'issue de l'histoire à venir est intimement liée au sort de la Compagnie. ",
3
);
INSERT INTO `movie` VALUES('Sean Astin, Elijah Wood, Viggo Mortensen',179,'Fantastique','américain, néo-zélandais','Peter Jackson',
"Après la mort de Boromir et la disparition de Gandalf, la Communauté s'est scindée en trois. Perdus dans les collines d'Emyn Muil, Frodon et Sam découvrent qu'ils sont suivis par Gollum, une créature versatile corrompue par l'Anneau. Celui-ci promet de conduire les Hobbits jusqu'à la Porte Noire du Mordor. A travers la Terre du Milieu, Aragorn, Legolas et Gimli font route vers le Rohan, le royaume assiégé de Theoden. Cet ancien grand roi, manipulé par l'espion de Saroumane, le sinistre Langue de Serpent, est désormais tombé sous la coupe du malfaisant Magicien. Eowyn, la nièce du Roi, reconnaît en Aragorn un meneur d'hommes. Entretemps, les Hobbits Merry et Pippin, prisonniers des Uruk-hai, se sont échappés et ont découvert dans la mystérieuse Forêt de Fangorn un allié inattendu : Sylvebarbe, gardien des arbres, représentant d'un ancien peuple végétal dont Saroumane a décimé la forêt... ",
4
);

INSERT INTO `movie` VALUES('Sean Astin, Elijah Wood, Viggo Mortensen',201,'Fantastique','américain, néo-zélandais','Peter Jackson',
"Les armées de Sauron ont attaqué Minas Tirith, la capitale de Gondor. Jamais ce royaume autrefois puissant n'a eu autant besoin de son roi. Mais Aragorn trouvera-t-il en lui la volonté d'accomplir sa destinée ?
Tandis que Gandalf s'efforce de soutenir les forces brisées de Gondor, Théoden exhorte les guerriers de Rohan à se joindre au combat. Mais malgré leur courage et leur loyauté, les forces des Hommes ne sont pas de taille à lutter contre les innombrables légions d'ennemis qui s'abattent sur le royaume...
Chaque victoire se paye d'immenses sacrifices. Malgré ses pertes, la Communauté se jette dans la bataille pour la vie, ses membres faisant tout pour détourner l'attention de Sauron afin de donner à Frodon une chance d'accomplir sa quête.
Voyageant à travers les terres ennemies, ce dernier doit se reposer sur Sam et Gollum, tandis que l'Anneau continue de le tenter... ",
5
);


/* Insertion dans game
developer 	genre 	platform 	publisher 	resume 	id 
 */
INSERT INTO `game` VALUES("EA GAMES", "Fantastique/Action/Aventure", "PC/PS2/XBOX", "Electronic Arts",
"Le Seigneur des Anneaux : La Communauté de l'Anneau est un jeu d'action/aventure sorti sur Playstation 2. Revivez l'histoire originale du premier livre du Seigneur des Anneaux en incarnant tour à tour le magicien Gandalf, le guerrier Aragorn et le Hobbit Frodon. Le jeu puise directement son inspiration dans le livre et laisse donc de côté tout le design issu du film de Peter Jackson.",
6);
INSERT INTO `game` VALUES("EA GAMES", "Fantastique/Action/Aventure", "PC/PS2/XBOX", "Electronic Arts",
"Le Seigneur des Anneaux : Les Deux Tours sur Playstation 2 est un concentré de combats épiques et sanglants, mais avant tout un vibrant hommage à l'oeuvre de Tolkien. Incarnez Aragorn, Legolas, Gimli ainsi que le légendaire Isildur, dans les moments clés de La Communauté de l'Anneau et des Deux Tours."
,7);
INSERT INTO `game` VALUES("EA GAMES", "Fantastique/Action/Aventure", "PC/PS2/XBOX", "Electronic Arts",
"Le Seigneur des Anneaux : Le Retour du Roi est un beat'em all dans lequel vous pourrez incarner l'un des 9 héros principaux tirés de la célèbre trilogie. Vous aurez l'honneur de participer aux plus grandes batailles de l'histoire de la Terre du Milieu."
,8);