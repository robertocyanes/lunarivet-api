package com.lunarivet.entity;

import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDateTime;

@Entity

@Table(name = "prescricoes")

@Getter
@Setter

@NoArgsConstructor

@AllArgsConstructor

@Builder

public class Prescricao {

    @Id

    @GeneratedValue(
            strategy =
                    GenerationType.IDENTITY
    )

    private Long id;

    @ManyToOne

    @JoinColumn(
            name = "consulta_id",
            nullable = false
    )

    private Consulta consulta;

    @ManyToOne

    @JoinColumn(
            name = "pet_id",
            nullable = false
    )

    private Pet pet;

    @ManyToOne

    @JoinColumn(
            name = "medicacao_id"
    )

    private Medicacao medicacao;

    private String dosagem;

    private String frequencia;

    private Integer duracaoDias;

    @Column(
            columnDefinition = "TEXT"
    )

    private String orientacoes;

    private LocalDateTime dataPrescricao;

    private String veterinario;

}