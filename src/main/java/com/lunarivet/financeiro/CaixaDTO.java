package com.lunarivet.financeiro;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CaixaDTO {

    private BigDecimal entradas;

    private BigDecimal saidas;

    private BigDecimal saldoAtual;

    private BigDecimal pendencias;

}