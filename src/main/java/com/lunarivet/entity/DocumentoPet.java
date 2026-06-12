package com.lunarivet.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "documentos_pet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocumentoPet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeArquivo;

    private String tipoDocumento;

    private String urlArquivo;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

}