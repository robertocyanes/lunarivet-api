package com.lunarivet.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home() {

        return """
                LunariVet API Online
                Clínica Veterinária
                Sistema operacional ativo
                """;
    }

}