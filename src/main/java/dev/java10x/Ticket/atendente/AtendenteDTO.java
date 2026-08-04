package dev.java10x.Ticket.atendente;

import dev.java10x.Ticket.ticket.TicketModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtendenteDTO {

    private Long id;

    private String nome;

    private int idade;

    private String email;

    private NivelSuporte nivelSuporte;

    private TicketModel ticket;
}
