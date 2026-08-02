package dev.java10x.Ticket.ticket;


import dev.java10x.Ticket.atendente.AtendenteModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_ticket")
public class TicketModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descricao;

    /*
     * @OneToMany
     * One(ticket)ToMany(atendentes)
     */
    @OneToMany(mappedBy = "ticket")
    private List<AtendenteModel> atendentes;
}
