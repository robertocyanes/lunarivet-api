package com.lunarivet.dashboard;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DashboardFinanceiroDTO {

    private BigDecimal faturamentoMes;

    private BigDecimal faturamentoAno;

    private BigDecimal pendenciasFinanceiras;

    private Long pagamentosRealizados;

    private Long pagamentosPendentes;

    private BigDecimal ticketMedio;

}