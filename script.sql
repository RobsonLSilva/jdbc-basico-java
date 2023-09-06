CREATE TABLE clientes (
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(50) DEFAULT NULL,
  cpf VARCHAR(14) DEFAULT NULL,
  telefone VARCHAR(14) DEFAULT NULL
); 

INSERT INTO clientes (nome, cpf, telefone)
VALUES ('Cliente 1', '111.111.111-11', '(11) 1111-1111');

INSERT INTO clientes (nome, cpf, telefone)
VALUES ('Cliente 2', '222.222.222-22', '(22) 2222-2222');

INSERT INTO clientes (nome, cpf, telefone)
VALUES ('Cliente 3', '333.333.333-33', '(33) 3333-3333');