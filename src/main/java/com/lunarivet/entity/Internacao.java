package com.lunarivet.entity;

import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDateTime;

@Entity

@Table(name = "internacoes")

@Getter
@Setter

@NoArgsConstructor

@AllArgsConstructor

@Builder

public class Internacao {

    @Id

    @GeneratedValue(
            strategy =
                    GenerationType.IDENTITY
    )

    private Long id;

    @ManyToOne

    @JoinColumn(
            name = "pet_id",
            nullable = false
    )

    private Pet pet;

    @Column(nullable = false)

    private LocalDateTime entrada;

    private LocalDateTime alta;

    @Column(
            columnDefinition =
                    "TEXT"
    )

    private String motivo;

    @Column(
            columnDefinition =
                    "TEXT"
    )

    private String observacoes;

    private String veterinarioResponsavel;

    private Boolean ativa;

    private String baia;

    @Column(
            columnDefinition =
                    "TEXT"
    )

    private String tratamento;

    @Column(
            columnDefinition =
                    "TEXT"
    )

    private String medicamentos;

}