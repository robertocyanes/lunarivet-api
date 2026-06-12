package com.lunarivet.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "prontuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String anotacoesGerais;

    @OneToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

}