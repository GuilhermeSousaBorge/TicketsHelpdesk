package dev.java10x.Ticket.ticket;

import org.springframework.stereotype.Component;

@Component
public class TicketMapper {

    public TicketModel map(TicketDTO ticketDTO) {
        return new TicketModel(
            ticketDTO.getId(),
            ticketDTO.getTitulo(),
            ticketDTO.getDescricao(),
            ticketDTO.getStatus(),
            null
        );
    }

    public TicketDTO map(TicketModel ticketModel) {
        return new TicketDTO(
            ticketModel.getId(),
            ticketModel.getTitulo(),
            ticketModel.getDescricao(),
            ticketModel.getStatus()
        );
    }
}
