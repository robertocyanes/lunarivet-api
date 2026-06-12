package com.lunarivet.controller;

import com.lunarivet.entity.HistoricoClinico;
import com.lunarivet.service.HistoricoClinicoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historico-clinico")
public class HistoricoClinicoController {

    private final HistoricoClinicoService service;

    public HistoricoClinicoController(
            HistoricoClinicoService service) {

        this.service = service;
    }

    @GetMapping
    public List<HistoricoClinico> listar() {

        return service.listar();
    }

    @GetMapping("/{id}")
    public HistoricoClinico buscar(
            @PathVariable Long id) {

        return service.buscar(id);
    }

    @PostMapping
    public HistoricoClinico salvar(
            @RequestBody HistoricoClinico historico) {

        return service.salvar(historico);
    }

    @PutMapping("/{id}")
    public HistoricoClinico atualizar(
            @PathVariable Long id,
            @RequestBody HistoricoClinico historico) {

        return service.atualizar(
                id,
                historico);
    }

    @DeleteMapping("/{id}")
    public void deletar(
            @PathVariable Long id) {

        service.deletar(id);
    }
}