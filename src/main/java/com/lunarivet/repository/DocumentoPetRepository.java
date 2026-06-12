package com.lunarivet.repository;

import com.lunarivet.entity.DocumentoPet;
import com.lunarivet.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentoPetRepository
        extends JpaRepository<DocumentoPet, Long> {

    List<DocumentoPet> findByPet(Pet pet);

}