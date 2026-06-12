package com.lunarivet.controller;

import com.lunarivet.entity.Exame;
import com.lunarivet.service.ExameService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exames")
public class ExameController {

    private final ExameService service;

    public ExameController(
            ExameService service){

        this.service=service;
    }

    @GetMapping
    public List<Exame> listar(){

        return service.listar();
    }

    @GetMapping("/{id}")
    public Exame buscar(
            @PathVariable Long id){

        return service.buscar(id);
    }

    @PostMapping
    public Exame salvar(
            @RequestBody Exame exame){

        return service.salvar(exame);
    }

    @PutMapping("/{id}")
    public Exame atualizar(
            @PathVariable Long id,

            @RequestBody Exame exame){

        return service.atualizar(
                id,
                exame);
    }

    @DeleteMapping("/{id}")
    public void deletar(
            @PathVariable Long id){

        service.deletar(id);
    }

}