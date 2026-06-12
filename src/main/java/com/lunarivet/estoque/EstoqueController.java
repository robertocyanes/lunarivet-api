package com.lunarivet.estoque;

import com.lunarivet.entity
        .EstoqueMedicamento;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/estoque")

@RequiredArgsConstructor

public class EstoqueController {

    private final
    EstoqueService
            service;

    @PutMapping(
            "/entrada/{id}"
    )

    public EstoqueMedicamento
    entrada(

            @PathVariable
            Long id,

            @RequestParam
            Integer quantidade

    ){

        return service
                .entrada(
                        id,
                        quantidade
                );

    }

    @PutMapping(
            "/saida/{id}"
    )

    public EstoqueMedicamento
    saida(

            @PathVariable
            Long id,

            @RequestParam
            Integer quantidade

    ){

        return service
                .saida(
                        id,
                        quantidade
                );

    }

    @GetMapping(
            "/baixo"
    )

    public List<
            EstoqueMedicamento>

    estoqueBaixo(){

        return service
                .estoqueBaixo();

    }

}