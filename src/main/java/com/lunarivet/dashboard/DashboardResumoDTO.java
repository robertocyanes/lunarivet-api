package com.lunarivet.dashboard;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DashboardResumoDTO {

    private Long totalPets;

    private Long totalTutores;

    private Long consultasHoje;

    private Long agendamentosPendentes;

    private Long vacinasPendentes;

    private BigDecimal faturamentoMes;

}