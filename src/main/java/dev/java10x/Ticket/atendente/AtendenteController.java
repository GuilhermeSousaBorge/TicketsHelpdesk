package dev.java10x.Ticket.atendente;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> boasVindas() {
        return ResponseEntity.ok("Hello World!");
    }

    @PostMapping("/criar")
    public ResponseEntity<AtendenteDTO> criarAtendente(@RequestBody AtendenteDTO atendenteDTO) {
        AtendenteDTO novoAtendente = atendenteService.criarAtendente(atendenteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAtendente);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<AtendenteDTO>> mostrarTodos() {
        return ResponseEntity.ok(atendenteService.listarTodosAtendentes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> mostrarAtendentePorId(@PathVariable Long id) {
        if (!verificarIdValido(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Atendente nao encontrado");
        }
        try {
            AtendenteDTO atendente = atendenteService.buscarAtendentePorId(id);
            return ResponseEntity.ok(atendente);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarAtendentePorId(@PathVariable Long id, @RequestBody AtendenteDTO novoAtendente) {
        if (!verificarIdValido(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Atendente nao encontrado");
        }
        try {
            AtendenteDTO atendente = atendenteService.editarAtendente(id, novoAtendente);
            return ResponseEntity.ok(atendente);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarAtendentePorId(@PathVariable Long id) {
        if (!verificarIdValido(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Atendente nao encontrado");
        }
        atendenteService.apagarAtendente(id);
        return ResponseEntity.noContent().build();
    }

    private boolean verificarIdValido(Long id) {
        AtendenteDTO atendenteExiste = atendenteService.buscarAtendentePorId(id);
        return atendenteExiste != null;
    }
}
