/*Cria Banco de dados com o nome BackTeste*/
CREATE SCHEMA BackTeste;

/*Utiliza o banco acima criado*/
USE BackTeste;

/*Cria tabela com todos os atributos de um cliente*/
CREATE TABLE tb_customer_account(
    id_customer INT NOT NULL,
    cpf_cnpj INT NOT NULL,
    nm_customer VARCHAR(40) NOT NULL,
    is_active INT NOT NULL,
    vl_total DECIMAL(10,2) NOT NULL,
    PRIMARY KEY(id_customer)
);
