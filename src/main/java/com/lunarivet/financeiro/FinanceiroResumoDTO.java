package com.lunarivet.financeiro;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FinanceiroResumoDTO {

    private BigDecimal totalRecebido;

    private BigDecimal totalPendente;

    private Long pagamentosRealizados;

    private Long pagamentosPendentes;

}