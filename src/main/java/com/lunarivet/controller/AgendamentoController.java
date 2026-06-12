package com.lunarivet.controller;

import com.lunarivet.entity.Agendamento;
import com.lunarivet.service.AgendamentoService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService service;

    @GetMapping
    public List<Agendamento> listar() {

        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Agendamento buscar(
            @PathVariable Long id) {

        return service.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Agendamento criar(
            @RequestBody Agendamento agendamento) {

        return service.salvar(agendamento);
    }

    @PutMapping("/{id}")
    public Agendamento atualizar(
            @PathVariable Long id,
            @RequestBody Agendamento agendamento) {

        return service.atualizar(id, agendamento);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(
            @PathVariable Long id) {

        service.deletar(id);
    }

}