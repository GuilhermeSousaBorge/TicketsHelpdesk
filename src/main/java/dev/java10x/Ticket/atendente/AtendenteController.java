package dev.java10x.Ticket.atendente;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("atendentes")
public class AtendenteController {

    private final AtendenteService atendenteService;

    public AtendenteController(AtendenteService atendenteService) {
        this.atendenteService = atendenteService;
    }

    @GetMapping("/boas-vindas")
    public String BoasVindas(){
        return "Hello World!";
    }

    @PostMapping("/criar")
    public AtendenteDTO criarAtendente(@RequestBody AtendenteDTO atendenteModel){
        return atendenteService.criarAtendente(atendenteModel);
    }

    @GetMapping("/todos")
    public List<AtendenteDTO> mostrarTodos(){
        return atendenteService.listarTodosAtendentes();
    }

    @GetMapping("/{id}")
    public AtendenteDTO mostrarAtendentePorId(@PathVariable Long id){
        return atendenteService.buscarAtendentePorId(id);
    }

    @PutMapping("/{id}")
    public AtendenteDTO editarAtendentePorId(@PathVariable Long id, @RequestBody AtendenteDTO novoAtendente){
        return atendenteService.editarAtendente(id, novoAtendente);
    }

    @DeleteMapping("/{id}")
    public void deletarAtendentePorId(@PathVariable Long id){
        atendenteService.apagarAtendente(id);
    }

}
