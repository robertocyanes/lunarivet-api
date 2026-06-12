package com.lunarivet.entity;

import jakarta.persistence.*;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity

@Table(name="estoque_medicamentos")

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor

@Builder

public class EstoqueMedicamento {

    @Id

    @GeneratedValue(
            strategy =
                    GenerationType.IDENTITY
    )

    private Long id;

    @Column(nullable=false)

    private String nome;

    private String fabricante;

    private String lote;

    private Integer quantidade;

    private Integer estoqueMinimo;

    private BigDecimal valorCompra;

    private BigDecimal valorVenda;

    private LocalDate validade;

    private Boolean ativo;

}