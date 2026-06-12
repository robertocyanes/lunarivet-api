package com.lunarivet.controller;

import com.lunarivet.entity.Tutor;
import com.lunarivet.service.TutorService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutores")
@RequiredArgsConstructor
public class TutorController {

    private final TutorService service;

    @GetMapping
    public List<Tutor> listar() {

        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Tutor buscar(
            @PathVariable Long id) {

        return service.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tutor criar(
            @RequestBody Tutor tutor) {

        return service.salvar(tutor);
    }

    @PutMapping("/{id}")
    public Tutor atualizar(
            @PathVariable Long id,
            @RequestBody Tutor tutor) {

        return service.atualizar(id, tutor);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(
            @PathVariable Long id) {

        service.deletar(id);
    }

}