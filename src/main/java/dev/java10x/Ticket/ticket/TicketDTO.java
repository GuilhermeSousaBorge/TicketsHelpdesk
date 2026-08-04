package dev.java10x.Ticket.ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDTO {

    private Long id;

    private String titulo;

    private String descricao;

    private String status;

}
