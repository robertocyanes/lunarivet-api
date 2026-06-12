package com.lunarivet.repository;

import com.lunarivet.entity.Pet;
import com.lunarivet.entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository
        extends JpaRepository<Pet, Long> {

    List<Pet>
    findByNomeContainingIgnoreCase(
            String nome
    );

    List<Pet>
    findByTutor(Tutor tutor);

}