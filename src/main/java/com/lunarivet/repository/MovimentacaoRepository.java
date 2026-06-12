package com.lunarivet.repository;

import com.lunarivet.entity
        .MovimentacaoEstoque;

import org.springframework.data.jpa.repository
        .JpaRepository;

public interface
MovimentacaoRepository

        extends JpaRepository
        <MovimentacaoEstoque,
                Long>{

}