package com.lunarivet.repository;

import com.lunarivet.entity.Prontuario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProntuarioRepository
        extends JpaRepository<Prontuario, Long> {

    Optional<Prontuario> findByPetId(Long petId);

}