package com.lunarivet.repository;

import com.lunarivet.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface PagamentoRepository
        extends JpaRepository<Pagamento, Long> {

    List<Pagamento>
    findByValorGreaterThan(
            BigDecimal valor
    );

}