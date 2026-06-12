package com.lunarivet.entity;

import jakarta.persistence.*;

import lombok.*;

import java.math.BigDecimal;

import java.time.LocalDate;

@Entity

@Table(name = "produtos_estoque")

@Getter
@Setter

@NoArgsConstructor

@AllArgsConstructor

@Builder

public class ProdutoEstoque {

    @Id

    @GeneratedValue(
            strategy =
                    GenerationType.IDENTITY
    )

    private Long id;

    @Column(
            nullable = false
    )

    private String nome;

    private String categoria;

    @Column(
            unique = true
    )

    private String codigo;

    private Integer quantidade;

    private Integer estoqueMinimo;

    private BigDecimal precoCompra;

    private BigDecimal precoVenda;

    private String fornecedor;

    private LocalDate validade;

    private String lote;

    private Boolean controlado;

    private Boolean ativo;

}