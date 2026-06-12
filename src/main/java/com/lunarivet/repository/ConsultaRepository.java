package com.lunarivet.repository;

import com.lunarivet.entity.Consulta;
import com.lunarivet.entity.Pet;
import com.lunarivet.enums.StatusConsulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultaRepository
        extends JpaRepository<Consulta, Long> {

    List<Consulta> findByPet(Pet pet);

    List<Consulta>
    findByStatus(StatusConsulta status);

}