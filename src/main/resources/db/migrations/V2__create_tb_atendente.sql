CREATE TABLE tb_atendente (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    idade int,
    nivel_suporte VARCHAR(3),
    ticket_id BIGINT,
    FOREIGN KEY (ticket_id) REFERENCES tb_ticket(id)
);