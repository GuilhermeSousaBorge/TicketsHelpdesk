package dev.java10x.Ticket.ticket;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tickets")
public class TicketController {

    @PostMapping("/criar")
    public String criarTicket(){
        return "Ticket criado com sucesso!";
    }

    @GetMapping("/todos")
    public String mostrarTodos(){
        return "Hello World!";
    }

    @GetMapping("/ticketId")
    public String mostrarTicketPorId(){
        return "Ticket encontrado!";
    }

    @PutMapping("/editarId")
    public String editarTicketPorId(){
        return "alterar Ticket por id";
    }

    @DeleteMapping("/deletarId")
    public String deletarTicketPorId(){
        return "deletar Ticket por id";
    }
}
