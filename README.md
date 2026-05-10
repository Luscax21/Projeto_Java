# Projeto_Java



# Sistema Automotivo - Gestão de Estoque de Veículos

## Sobre o Projeto
Este projeto é um sistema web desenvolvido para a gestão eficiente do inventário de veículos de concessionárias. O objetivo é substituir controlos manuais e planilhas por uma plataforma digital que permite o registo, atualização, remoção e consulta rápida de veículos e marcas.

Projeto desenvolvido como requisito de avaliação para a **UniFECAF**.

## Tecnologias Utilizadas
O projeto foi construído com uma arquitetura baseada em **API REST** e integração com banco de dados relacional.

**Backend:**
* Java (Orientação a Objetos)
* Spring Boot (Web, Data JPA)
* Maven (Gestão de dependências)

**Banco de Dados:**
* H2 Database (Banco em memória para testes e desenvolvimento ágil)
* MySQL (Script de modelagem física incluído para ambiente de produção)

**Frontend:**
* HTML5, CSS3 e JavaScript (Vanilla)
* Integração assíncrona com a API via `fetch`

## Funcionalidades (CRUD)
* **Gestão de Marcas:** Registo de novas marcas com país de origem.
* **Gestão de Veículos:** Cadastro detalhado (Modelo, Ano, Cor, Preço, Quilometragem, Status).
* **Filtros Avançados:** Consulta de veículos por Marca e Status de disponibilidade.
* **Atualização Dinâmica:** Alteração do status do veículo (Disponível, Vendido, Reservado) diretamente via Modal interativo.
* **Remoção Segura:** Exclusão de veículos descontinuados ou vendidos.

## Como Executar o Projeto

1. Clone este repositório para a sua máquina local.
2. Certifique-se de ter o **Java 17** (ou superior) e o **Maven** instalados.
3. Abra o terminal na pasta raiz do projeto e execute o comando:
   ```bash
   mvn spring-boot:run
