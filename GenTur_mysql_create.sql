CREATE TABLE `tb_categoria` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`servicos` BOOLEAN,
	`tipo` varchar(255),
	`promocao` BOOLEAN,
	PRIMARY KEY (`id`)
);

CREATE TABLE `tb_produto` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`Nome` varchar(255),
	`descricao` varchar(2000),
	`preco` DECIMAL(5,2) NOT NULL,
	`foto` varchar(255),
	`tb_categoria_id` bigint NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `tb_usuario` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`emailUsuario` varchar(255),
	`senha` varchar(255),
	`nomeCompleto` varchar(255),
	`DadosPessoais` varchar(255),
	`DadosPagamento` varchar(255),
	`foto` varchar(255),
	PRIMARY KEY (`id`)
);

ALTER TABLE `tb_produto` ADD CONSTRAINT `tb_produto_fk0` FOREIGN KEY (`tb_categoria_id`) REFERENCES `tb_categoria`(`id`);




