package com.lunarivet.entity;

import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDateTime;

@Entity

@Table(name="movimentacoes_estoque")

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor

@Builder

public class MovimentacaoEstoque {

    @Id

    @GeneratedValue(
            strategy =
                    GenerationType.IDENTITY
    )

    private Long id;

    private String tipo;

    private Integer quantidade;

    private LocalDateTime dataHora;

    private String observacao;

    @ManyToOne

    @JoinColumn(
            name="medicamento_id"
    )

    private EstoqueMedicamento medicamento;

}