package com.lunarivet.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "historicos_clinicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoricoClinico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String alergias;

    @Column(columnDefinition = "TEXT")
    private String doencasCronicas;

    @Column(columnDefinition = "TEXT")
    private String observacoes;

    @OneToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

}