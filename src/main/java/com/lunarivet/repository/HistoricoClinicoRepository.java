package com.lunarivet.repository;

import com.lunarivet.entity.HistoricoClinico;
import com.lunarivet.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoricoClinicoRepository
        extends JpaRepository<HistoricoClinico, Long> {

    List<HistoricoClinico>
    findByPet(Pet pet);

}