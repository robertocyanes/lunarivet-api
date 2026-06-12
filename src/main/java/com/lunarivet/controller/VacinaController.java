package com.lunarivet.controller;

import com.lunarivet.entity.Vacina;
import com.lunarivet.service.VacinaService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacinas")
@RequiredArgsConstructor
public class VacinaController {

    private final VacinaService service;

    @GetMapping
    public List<Vacina> listar() {

        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Vacina buscar(
            @PathVariable Long id) {

        return service.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vacina criar(
            @RequestBody Vacina vacina) {

        return service.salvar(vacina);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(
            @PathVariable Long id) {

        service.deletar(id);
    }

}