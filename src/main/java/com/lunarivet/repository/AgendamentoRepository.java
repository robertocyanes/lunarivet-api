package com.lunarivet.repository;

import com.lunarivet.entity.Agendamento;
import com.lunarivet.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AgendamentoRepository
        extends JpaRepository<Agendamento, Long> {

    List<Agendamento> findByPet(Pet pet);

    List<Agendamento>
    findByDataHoraBetween(
            LocalDateTime inicio,
            LocalDateTime fim
    );

}