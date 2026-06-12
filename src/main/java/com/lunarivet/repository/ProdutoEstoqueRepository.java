package com.lunarivet.repository;

import com.lunarivet.entity.ProdutoEstoque;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProdutoEstoqueRepository
        extends JpaRepository<
        ProdutoEstoque,
        Long> {

    Optional<ProdutoEstoque> findByCodigo(
            String codigo
    );

    List<ProdutoEstoque> findByNomeContainingIgnoreCase(
            String nome
    );

    List<ProdutoEstoque> findByQuantidadeLessThanEqual(
            Integer quantidade
    );

}