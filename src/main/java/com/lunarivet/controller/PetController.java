package com.lunarivet.controller;

import com.lunarivet.entity.Pet;
import com.lunarivet.service.PetService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetController {

    private final PetService service;

    @GetMapping
    public List<Pet> listar() {

        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Pet buscar(
            @PathVariable Long id) {

        return service.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pet criar(
            @RequestBody Pet pet) {

        return service.salvar(pet);
    }

    @PutMapping("/{id}")
    public Pet atualizar(
            @PathVariable Long id,
            @RequestBody Pet pet) {

        return service.atualizar(id, pet);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(
            @PathVariable Long id) {

        service.deletar(id);
    }

}