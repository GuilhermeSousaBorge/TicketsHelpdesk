package dev.java10x.Ticket.ticket;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("tickets")
public class TicketViewController {

    private final TicketService ticketService;

    public TicketViewController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public String listarTickets(Model model) {
        model.addAttribute("tickets", ticketService.listarTickets());
        return "ticket/lista";
    }

    @GetMapping("/novo")
    public String formNovoTicket(Model model) {
        model.addAttribute("ticket", new TicketDTO());
        return "ticket/form";
    }

    @GetMapping("/{id}/editar")
    public String formEditarTicket(@PathVariable Long id, Model model) {
        model.addAttribute("ticket", ticketService.buscarTicketPorId(id));
        return "ticket/form";
    }

    @PostMapping("/salvar")
    public String salvarTicket(@ModelAttribute TicketDTO ticketDTO) {
        if (ticketDTO.getId() != null) {
            ticketService.editarTicket(ticketDTO.getId(), ticketDTO);
        } else {
            ticketService.criarTicket(ticketDTO);
        }
        return "redirect:/tickets";
    }

    @GetMapping("/{id}/deletar")
    public String deletarTicket(@PathVariable Long id) {
        ticketService.apagarTicket(id);
        return "redirect:/tickets";
    }
}
