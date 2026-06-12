package com.lunarivet.estoque;

import com.lunarivet.entity.*;

import com.lunarivet.repository.*;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import java.util.List;

@Service

@RequiredArgsConstructor

public class EstoqueService {

    private final
    EstoqueMedicamentoRepository
            repository;

    private final
    MovimentacaoRepository
            movimentacaoRepository;

    public EstoqueMedicamento
    entrada(

            Long id,

            Integer quantidade

    ){

        EstoqueMedicamento item=

                repository
                        .findById(id)

                        .orElseThrow();

        item.setQuantidade(

                item.getQuantidade()
                        + quantidade

        );

        repository.save(item);

        registrarMovimento(

                item,

                "ENTRADA",

                quantidade

        );

        return item;

    }

    public EstoqueMedicamento
    saida(

            Long id,

            Integer quantidade

    ){

        EstoqueMedicamento item=

                repository
                        .findById(id)

                        .orElseThrow();

        item.setQuantidade(

                item.getQuantidade()
                        - quantidade

        );

        repository.save(item);

        registrarMovimento(

                item,

                "SAIDA",

                quantidade

        );

        return item;

    }

    public List<EstoqueMedicamento>

    estoqueBaixo(){

        return repository

                .findAll()

                .stream()

                .filter(

                        item->

                                item.getQuantidade()

                                        <=

                                        item.getEstoqueMinimo()

                )

                .toList();

    }

    private void registrarMovimento(

            EstoqueMedicamento item,

            String tipo,

            Integer quantidade

    ){

        movimentacaoRepository

                .save(

                        MovimentacaoEstoque

                                .builder()

                                .tipo(tipo)

                                .quantidade(quantidade)

                                .dataHora(
                                        LocalDateTime.now()
                                )

                                .medicamento(item)

                                .build()

                );

    }

}