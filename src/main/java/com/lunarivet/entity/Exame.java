package com.lunarivet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "exames")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Exame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private LocalDate dataExame;

    private String laboratorio;

    @Column(columnDefinition = "TEXT")
    private String resultado;

    private String arquivoResultado;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

}