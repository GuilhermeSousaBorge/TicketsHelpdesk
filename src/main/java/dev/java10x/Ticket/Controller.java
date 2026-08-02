package dev.java10x.Ticket;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {

    @GetMapping("/boas-vindas")
    public String BoasVindas(){
        return "Hello World!";
    }

}
