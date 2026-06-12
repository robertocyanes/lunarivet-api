package com.lunarivet.repository;

import com.lunarivet.entity.Medicacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentoRepository
        extends JpaRepository<Medicacao, Long> {

}