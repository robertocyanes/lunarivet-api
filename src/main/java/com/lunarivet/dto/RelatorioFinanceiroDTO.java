package com.lunarivet.relatorios.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class RelatorioFinanceiroDTO {

    private BigDecimal faturamento;

    private Long pagamentos;

}