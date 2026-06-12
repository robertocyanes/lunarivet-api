package com.lunarivet.controller;

import com.lunarivet.entity.Internacao;

import com.lunarivet.service.InternacaoService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/internacoes")

@RequiredArgsConstructor

public class InternacaoController {

    private final
    InternacaoService service;

    @GetMapping

    public List<Internacao>

    listar(){

        return service.listarTodos();

    }

    @GetMapping("/{id}")

    public Internacao buscar(

            @PathVariable
            Long id){

        return service.buscarPorId(id);

    }

    @PostMapping

    public Internacao salvar(

            @RequestBody
            Internacao internacao){

        return service.salvar(

                internacao);

    }

    @PutMapping("/{id}")

    public Internacao atualizar(

            @PathVariable
            Long id,

            @RequestBody
            Internacao internacao){

        return service.atualizar(

                id,

                internacao);

    }

    @DeleteMapping("/{id}")

    public void excluir(

            @PathVariable
            Long id){

        service.excluir(id);

    }

}