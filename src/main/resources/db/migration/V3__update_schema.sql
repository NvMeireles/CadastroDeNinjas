-- Criar tabela de missoes
CREATE TABLE tb_missoes (
                            id BIGSERIAL PRIMARY KEY,
                            nome VARCHAR(255) NOT NULL,
                            dificuldade VARCHAR(255)
);

-- Atualizar tb_cadastro
ALTER TABLE tb_cadastro
    ADD COLUMN email VARCHAR(255) UNIQUE;

ALTER TABLE tb_cadastro
    ADD COLUMN img_url VARCHAR(255);

ALTER TABLE tb_cadastro
    ADD COLUMN missoes_id BIGINT;

-- Criar foreign key
ALTER TABLE tb_cadastro
    ADD CONSTRAINT fk_missoes
        FOREIGN KEY (missoes_id)
            REFERENCES tb_missoes(id);