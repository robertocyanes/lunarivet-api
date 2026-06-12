package com.lunarivet.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "medicacoes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Medicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String dosagem;

    private String frequencia;

    private Integer duracaoDias;

    @Column(columnDefinition = "TEXT")
    private String orientacoes;

    @ManyToOne
    @JoinColumn(name = "consulta_id")
    private Consulta consulta;

}