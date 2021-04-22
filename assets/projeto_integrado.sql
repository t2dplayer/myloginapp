use projeto_integrado;
/* projeto_integrado_logico: */

CREATE TABLE projeto (
    codigo INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome_projeto VARCHAR(255) NOT NULL,
    nome_responsavel VARCHAR(255) NOT NULL,
    email_responsavel VARCHAR(255) NULL,
    data_inicio DATE NOT NULL,
    data_fim DATE NOT NULL,
    situacao ENUM('ANDAMENTO', 'CANCELADO', 'FINALIZADO') DEFAULT 'ANDAMENTO'
);

CREATE TABLE tcc (
    codigo INTEGER PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    situacao ENUM('DESENVOLVIMENTO', 'DEFENDIDO', 'ABANDONADO') DEFAULT 'DESENVOLVIMENTO',
    fk_projeto_codigo INTEGER NULL
);

CREATE TABLE artigo (
    codigo INTEGER PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    natureza ENUM('RESUMO', 'COMPLETO') DEFAULT 'RESUMO',
    autor VARCHAR(255) NOT NULL,
    email_autor VARCHAR(255) NULL,
    fk_projeto_codigo INTEGER NULL
);

CREATE TABLE coautor (
    codigo INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    fk_artigo_codigo INTEGER NOT NULL
);
 
ALTER TABLE tcc ADD CONSTRAINT FK_tcc_2
    FOREIGN KEY (fk_projeto_codigo)
    REFERENCES projeto (codigo)
    ON DELETE CASCADE;
 
ALTER TABLE artigo ADD CONSTRAINT FK_artigo_2
    FOREIGN KEY (fk_projeto_codigo)
    REFERENCES projeto (codigo)
    ON DELETE CASCADE;
 
ALTER TABLE coautor ADD CONSTRAINT FK_coautor_2
    FOREIGN KEY (fk_artigo_codigo)
    REFERENCES artigo (codigo)
    ON DELETE CASCADE;