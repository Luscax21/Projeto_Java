CREATE DATABASE IF NOT EXISTS estoque_veiculos;
USE estoque_veiculos;

-- Criar a tabela de Marcas 
CREATE TABLE tb_marcas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    pais_origem VARCHAR(255)
);

-- Criar a tabela de Veículos 
CREATE TABLE tb_veiculos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    marca_id BIGINT,
    modelo VARCHAR(255) NOT NULL,
    ano_fabricacao INT,
    cor VARCHAR(50),
    preco DOUBLE,
    quilometragem INT,
    status VARCHAR(50),
    CONSTRAINT fk_veiculo_marca FOREIGN KEY (marca_id) REFERENCES tb_marcas(id)
);

-- Dados de teste
INSERT INTO tb_marcas (nome, pais_origem) VALUES ('Toyota', 'Japão');
INSERT INTO tb_marcas (nome, pais_origem) VALUES ('Honda', 'Japão');

INSERT INTO tb_veiculos (marca_id, modelo, ano_fabricacao, cor, preco, quilometragem, status) 
VALUES (1, 'Corolla XEI', 2023, 'Prata', 140000.00, 15000, 'Disponível');