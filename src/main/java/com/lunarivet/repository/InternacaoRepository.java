package com.lunarivet.repository;

import com.lunarivet.entity.Internacao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InternacaoRepository

        extends JpaRepository<
        Internacao,
        Long> {

    List<Internacao>

    findByAtiva(

            Boolean ativa

    );

    List<Internacao>

    findByVeterinarioResponsavelContainingIgnoreCase(

            String veterinario

    );

}