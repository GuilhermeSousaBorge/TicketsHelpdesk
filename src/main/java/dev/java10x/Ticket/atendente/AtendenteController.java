package dev.java10x.Ticket.atendente;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AtendenteController {

    @GetMapping("/boas-vindas")
    public String BoasVindas(){
        return "Hello World!";
    }

    @PostMapping("/criar")
    public String criarAtendente(){
        return "Atendente criado com sucesso!";
    }

    @GetMapping("/todos")
    public String mostrarTodos(){
        return "Hello World!";
    }

    @GetMapping("/atendenteId")
    public String mostrarAtendentePorId(){
        return "Atendente encontrado!";
    }

    @PutMapping("/editarId")
    public String editarAtendentePorId(){
        return "alterar atendente por id";
    }

    @DeleteMapping("/deletarId")
    public String deletarAtendentePorId(){
        return "deletar atendente por id";
    }

}
