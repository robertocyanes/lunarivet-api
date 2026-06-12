package com.lunarivet.controller;

import com.lunarivet.entity.Prescricao;

import com.lunarivet.service.PrescricaoService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping(
        "/prescricoes"
)

@RequiredArgsConstructor

public class PrescricaoController {

    private final
    PrescricaoService service;

    @GetMapping

    public List<Prescricao>

    listar(){

        return service.listar();

    }

    @GetMapping("/{id}")

    public Prescricao buscar(

            @PathVariable
            Long id){

        return service.buscar(id);

    }

    @PostMapping

    public Prescricao salvar(

            @RequestBody
            Prescricao prescricao){

        return service.salvar(

                prescricao

        );

    }

    @DeleteMapping("/{id}")

    public void excluir(

            @PathVariable
            Long id){

        service.excluir(id);

    }

}