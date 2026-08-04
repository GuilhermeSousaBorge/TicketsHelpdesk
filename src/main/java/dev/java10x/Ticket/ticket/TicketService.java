package dev.java10x.Ticket.ticket;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    public TicketService(TicketRepository ticketRepository, TicketMapper ticketMapper) {
        this.ticketRepository = ticketRepository;
        this.ticketMapper = ticketMapper;
    }

    public TicketDTO criarTicket(TicketDTO ticketDTO) {
        TicketModel ticket = ticketMapper.map(ticketDTO);
        ticket = ticketRepository.save(ticket);
        return ticketMapper.map(ticket);
    }

    public List<TicketDTO> listarTickets() {
        return ticketRepository.findAll().stream().map(ticketMapper::map).toList();
    }

    public TicketDTO buscarTicketPorId(Long id) {
        TicketModel ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket nao encontrado"));
        return ticketMapper.map(ticket);
    }

    public TicketDTO editarTicket(Long id, TicketDTO ticketDTO) {
        TicketModel ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket nao encontrado"));
        ticket.setTitulo(ticketDTO.getTitulo());
        ticket.setDescricao(ticketDTO.getDescricao());
        ticket.setStatus(ticketDTO.getStatus());
        ticket = ticketRepository.save(ticket);
        return ticketMapper.map(ticket);
    }

    public void apagarTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}
