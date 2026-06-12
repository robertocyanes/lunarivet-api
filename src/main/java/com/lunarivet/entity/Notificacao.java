package com.lunarivet.entity;

import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDateTime;

@Entity

@Table(name="notificacoes")

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor

@Builder

public class Notificacao {

    @Id

    @GeneratedValue(
            strategy =
                    GenerationType.IDENTITY
    )

    private Long id;

    private String titulo;

    @Column(
            columnDefinition="TEXT"
    )
    private String mensagem;

    private Boolean lida;

    private String tipo;

    private LocalDateTime dataCriacao;

}