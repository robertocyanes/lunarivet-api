package com.lunarivet.repository;

import com.lunarivet.entity.EstoqueMedicamento;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface
EstoqueMedicamentoRepository

        extends JpaRepository
        <EstoqueMedicamento,Long>{

    List<EstoqueMedicamento>

    findByQuantidadeLessThanEqual(
            Integer quantidade
    );

}