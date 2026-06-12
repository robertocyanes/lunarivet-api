package com.lunarivet.repository;

import com.lunarivet.entity.Cirurgia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CirurgiaRepository
        extends JpaRepository<Cirurgia, Long> {

    List<Cirurgia> findByPetId(Long petId);

    List<Cirurgia> findByRealizada(Boolean realizada);

    List<Cirurgia> findByVeterinarioContainingIgnoreCase(
            String veterinario
    );

    List<Cirurgia> findByDataCirurgiaBetween(
            LocalDateTime inicio,
            LocalDateTime fim
    );
}