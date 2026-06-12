package com.lunarivet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "vacinas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vacina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private LocalDate dataAplicacao;

    private LocalDate proximaDose;

    private String fabricante;

    private String lote;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

}