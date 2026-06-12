package com.lunarivet.financeiro;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RelatorioMensalDTO {

    private Integer mes;

    private Integer ano;

    private Long totalConsultas;

    private Long totalPagamentos;

    private BigDecimal faturamento;

    private BigDecimal ticketMedio;

    private BigDecimal inadimplencia;

}