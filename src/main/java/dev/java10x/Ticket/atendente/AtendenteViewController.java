package dev.java10x.Ticket.atendente;

import dev.java10x.Ticket.ticket.TicketModel;
import dev.java10x.Ticket.ticket.TicketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("atendentes")
public class AtendenteViewController {

    private final AtendenteService atendenteService;
    private final TicketService ticketService;

    public AtendenteViewController(AtendenteService atendenteService, TicketService ticketService) {
        this.atendenteService = atendenteService;
        this.ticketService = ticketService;
    }

    @GetMapping
    public String listarAtendentes(Model model) {
        model.addAttribute("atendentes", atendenteService.listarTodosAtendentes());
        return "atendente/lista";
    }

    @GetMapping("/novo")
    public String formNovoAtendente(Model model) {
        model.addAttribute("atendente", new AtendenteDTO());
        model.addAttribute("niveis", NivelSuporte.values());
        model.addAttribute("ticketsDisponiveis", ticketService.listarTickets());
        return "atendente/form";
    }

    @GetMapping("/{id}/editar")
    public String formEditarAtendente(@PathVariable Long id, Model model) {
        model.addAttribute("atendente", atendenteService.buscarAtendentePorId(id));
        model.addAttribute("niveis", NivelSuporte.values());
        model.addAttribute("ticketsDisponiveis", ticketService.listarTickets());
        return "atendente/form";
    }

    @PostMapping("/salvar")
    public String salvarAtendente(@ModelAttribute AtendenteDTO atendenteDTO,
                                  @RequestParam(required = false) Long ticketId) {
        if (ticketId != null) {
            TicketModel ticket = new TicketModel();
            ticket.setId(ticketId);
            atendenteDTO.setTicket(ticket);
        }
        if (atendenteDTO.getId() != null) {
            atendenteService.editarAtendente(atendenteDTO.getId(), atendenteDTO);
        } else {
            atendenteService.criarAtendente(atendenteDTO);
        }
        return "redirect:/atendentes";
    }

    @GetMapping("/{id}/deletar")
    public String deletarAtendente(@PathVariable Long id) {
        atendenteService.apagarAtendente(id);
        return "redirect:/atendentes";
    }
}
