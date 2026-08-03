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
    public AtendenteModel criarAtendente(@RequestBody AtendenteModel atendenteModel){
        return atendenteService.criarAtendente(atendenteModel);
    }

    @GetMapping("/todos")
    public List<AtendenteModel> mostrarTodos(){
        return atendenteService.listarTodosAtendentes();
    }

    @GetMapping("/{id}")
    public AtendenteModel mostrarAtendentePorId(@PathVariable Long id){
        return atendenteService.buscarAtendentePorId(id);
    }

    @PutMapping("/{id}")
    public AtendenteModel editarAtendentePorId(@PathVariable Long id, @RequestBody AtendenteModel novoAtendente){
        return atendenteService.editarAtendente(id, novoAtendente);
    }

    @DeleteMapping("/{id}")
    public void deletarAtendentePorId(@PathVariable Long id){
        atendenteService.apagarAtendente(id);
    }

}
