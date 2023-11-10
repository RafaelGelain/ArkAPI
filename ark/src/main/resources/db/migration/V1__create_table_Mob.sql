CREATE TABLE `mob` (
 `id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `imagem` varchar(255) DEFAULT NULL,
 `nome` varchar(255) NOT NULL,
 `tipo` enum('Voador','Terrestre','Aquatico') DEFAULT NULL,
 `comportamento` enum('Passifico','Agressivo','Neutro') DEFAULT NULL,
 `comida` enum('Carnivoro','Herbivoro','Outros') DEFAULT NULL
);
