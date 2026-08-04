package dev.java10x.Ticket.ticket;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/criar")
    public ResponseEntity<TicketDTO> criarTicket(@RequestBody TicketDTO ticketDTO) {
        TicketDTO novoTicket = ticketService.criarTicket(ticketDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoTicket);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<TicketDTO>> mostrarTodos() {
        return ResponseEntity.ok(ticketService.listarTickets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> mostrarTicketPorId(@PathVariable Long id) {
        if (!verificarIdValido(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ticket nao encontrado");
        }
        try {
            TicketDTO ticket = ticketService.buscarTicketPorId(id);
            return ResponseEntity.ok(ticket);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarTicketPorId(@PathVariable Long id, @RequestBody TicketDTO ticketDTO) {
        if (!verificarIdValido(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ticket nao encontrado");
        }
        try {
            TicketDTO ticket = ticketService.editarTicket(id, ticketDTO);
            return ResponseEntity.ok(ticket);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarTicketPorId(@PathVariable Long id) {
        if (!verificarIdValido(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ticket nao encontrado");
        }
        ticketService.apagarTicket(id);
        return ResponseEntity.noContent().build();
    }

    private boolean verificarIdValido(Long id) {
        TicketDTO ticketExiste = ticketService.buscarTicketPorId(id);
        return ticketExiste != null;
    }
}
