package com.lunarivet.repository;

import com.lunarivet.entity.Exame;
import com.lunarivet.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExameRepository
        extends JpaRepository<Exame, Long> {

    List<Exame> findByPet(Pet pet);

}