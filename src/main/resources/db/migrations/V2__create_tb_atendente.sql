CREATE TABLE tb_atendente (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    idade int,
    nivelSuporte VARCHAR(3),
    ticket_id BIGINT,
    FOREIGN KEY (ticket_id) REFERENCES tb_ticket(id)
);