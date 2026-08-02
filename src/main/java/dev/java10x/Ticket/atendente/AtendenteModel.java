package dev.java10x.Ticket.atendente;

import dev.java10x.Ticket.ticket.TicketModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_atendente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtendenteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private int idade;

    @Column(unique = true)
    private String email;

    private NivelSuporte nivelSuporte;

    /*
    * @ManyToOne
    * Many(atendentes)ToOne(ticket)
    */
    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private TicketModel ticket;
}
