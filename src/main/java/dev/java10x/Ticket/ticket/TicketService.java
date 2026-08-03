package dev.java10x.Ticket.ticket;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public TicketModel criarTicket(TicketModel ticketModel) {
        return ticketRepository.save(ticketModel);
    }

    public List<TicketModel> listarTickets() {
        return ticketRepository.findAll();
    }

    public TicketModel buscarTicketPorId(Long id) {
        return ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket não encontrado"));
    }

    public TicketModel editarTicket(Long id, TicketModel ticketModel){

        TicketModel ticket = ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket não encontrado"));
        ticket.setTitulo(ticketModel.getTitulo());
        ticket.setDescricao(ticketModel.getDescricao());
        ticket.setStatus(ticketModel.getStatus());
        return ticketRepository.save(ticket);
    }

    public void apagarTicket(Long id){
        ticketRepository.deleteById(id);
    }
}
