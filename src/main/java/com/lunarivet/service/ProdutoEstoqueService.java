package com.lunarivet.service;

import com.lunarivet.entity.ProdutoEstoque;

import com.lunarivet.exception.ResourceNotFoundException;

import com.lunarivet.repository.ProdutoEstoqueRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

@RequiredArgsConstructor

public class ProdutoEstoqueService {

    private final
    ProdutoEstoqueRepository repository;

    public ProdutoEstoque salvar(

            ProdutoEstoque produto){

        return repository.save(

                produto);

    }

    public List<ProdutoEstoque>

    listarTodos(){

        return repository.findAll();

    }

    public ProdutoEstoque

    buscarPorId(

            Long id){

        return repository

                .findById(id)

                .orElseThrow(

                        ()->

                                new ResourceNotFoundException(

                                        "Produto não encontrado"

                                )

                );

    }

    public ProdutoEstoque atualizar(

            Long id,

            ProdutoEstoque dados){

        ProdutoEstoque atual=

                buscarPorId(id);

        atual.setNome(

                dados.getNome());

        atual.setCategoria(

                dados.getCategoria());

        atual.setCodigo(

                dados.getCodigo());

        atual.setQuantidade(

                dados.getQuantidade());

        atual.setEstoqueMinimo(

                dados.getEstoqueMinimo());

        atual.setPrecoCompra(

                dados.getPrecoCompra());

        atual.setPrecoVenda(

                dados.getPrecoVenda());

        atual.setFornecedor(

                dados.getFornecedor());

        atual.setValidade(

                dados.getValidade());

        atual.setLote(

                dados.getLote());

        atual.setControlado(

                dados.getControlado());

        atual.setAtivo(

                dados.getAtivo());

        return repository.save(

                atual);

    }

    public void excluir(

            Long id){

        repository.deleteById(

                id);

    }

}