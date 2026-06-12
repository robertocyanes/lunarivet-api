package com.lunarivet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "cirurgias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cirurgia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String procedimento;

    private LocalDateTime dataCirurgia;

    private String veterinario;

    @Column(columnDefinition = "TEXT")
    private String observacoes;

    private BigDecimal custo;

    private Boolean realizada;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

}