package dev.java10x.Ticket.ticket;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/criar")
    public TicketModel criarTicket(@RequestBody TicketModel ticketModel){
        return ticketService.criarTicket(ticketModel);
    }

    @GetMapping("/todos")
    public List<TicketModel> mostrarTodos(){
        return ticketService.listarTickets();
    }

    @GetMapping("/{id}")
    public TicketModel mostrarTicketPorId(@PathVariable Long id){
        return ticketService.buscarTicketPorId(id);
    }

    @PutMapping("/{id}")
    public TicketModel editarTicketPorId(@PathVariable Long id, @RequestBody TicketModel ticketModel){
        return ticketService.editarTicket(id, ticketModel);
    }

    @DeleteMapping("/{id}")
    public TicketModel deletarTicketPorId(@PathVariable Long id){
        ticketService.apagarTicket(id);
        return new TicketModel();
    }
}
