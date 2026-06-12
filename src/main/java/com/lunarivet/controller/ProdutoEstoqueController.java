package com.lunarivet.controller;

import com.lunarivet.entity.ProdutoEstoque;

import com.lunarivet.service.ProdutoEstoqueService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping(
        "/estoque"
)

@RequiredArgsConstructor

public class ProdutoEstoqueController {

    private final
    ProdutoEstoqueService service;

    @GetMapping

    public List<ProdutoEstoque>

    listar(){

        return service.listarTodos();

    }

    @GetMapping("/{id}")

    public ProdutoEstoque

    buscar(

            @PathVariable

            Long id){

        return service.buscarPorId(id);

    }

    @PostMapping

    public ProdutoEstoque salvar(

            @RequestBody

            ProdutoEstoque produto){

        return service.salvar(

                produto);

    }

    @PutMapping("/{id}")

    public ProdutoEstoque atualizar(

            @PathVariable

            Long id,

            @RequestBody

            ProdutoEstoque produto){

        return service.atualizar(

                id,

                produto);

    }

    @DeleteMapping("/{id}")

    public void excluir(

            @PathVariable

            Long id){

        service.excluir(

                id);

    }

}