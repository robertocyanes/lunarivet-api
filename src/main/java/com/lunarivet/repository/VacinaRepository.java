package com.lunarivet.repository;

import com.lunarivet.entity.Pet;
import com.lunarivet.entity.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface VacinaRepository
        extends JpaRepository<Vacina, Long> {

    List<Vacina> findByPet(Pet pet);

    List<Vacina>
    findByProximaDoseBefore(
            LocalDate data
    );

}