CREATE DATABASE banco;
CREATE TABLE `usuarios` (
	`ordem` INT NOT NULL AUTO_INCREMENT UNIQUE,
	`cpf` varchar(12) NOT NULL,
	`nome` varchar(50) NOT NULL,
	`cargo` varchar(15) NOT NULL,
	`senha` varchar(10) NOT NULL,
	PRIMARY KEY (`cpf`)
);

CREATE TABLE `conta` (
	`titular` varchar(50) NOT NULL,
	`numConta` INT NOT NULL,
	`cpf` varchar(12) NOT NULL UNIQUE,
	`saldo` FLOAT NOT NULL DEFAULT '0',
	`tipoConta` varchar(12) NOT NULL DEFAULT '0',
	`emprestimo` BOOLEAN NOT NULL DEFAULT false,
	PRIMARY KEY (`numConta`)
);

CREATE TABLE `historico` (
	`numConta` INT NOT NULL,
	`operacao` varchar(20) NOT NULL,
	`detalhes` DATETIME NOT NULL
);

ALTER TABLE `conta` ADD CONSTRAINT `conta_fk0` FOREIGN KEY (`cpf`) REFERENCES `usuarios`(`cpf`);

ALTER TABLE `historico` ADD CONSTRAINT `historico_fk0` FOREIGN KEY (`numConta`) REFERENCES `conta`(`numConta`);




