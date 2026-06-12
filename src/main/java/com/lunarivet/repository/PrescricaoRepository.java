package com.lunarivet.repository;

import com.lunarivet.entity.Prescricao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrescricaoRepository

        extends JpaRepository<
        Prescricao,
        Long> {

    List<Prescricao>

    findByPetId(

            Long petId

    );

    List<Prescricao>

    findByConsultaId(

            Long consultaId

    );

}