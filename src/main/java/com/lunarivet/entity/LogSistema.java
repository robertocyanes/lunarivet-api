package com.lunarivet.entity;

import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "logs_sistema")

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor

@Builder

public class LogSistema {

    @Id
    @GeneratedValue(
            strategy =
                    GenerationType.IDENTITY
    )
    private Long id;

    private String usuario;

    private String endpoint;

    private String metodoHttp;

    private String acao;

    private String ip;

    private Integer statusHttp;

    private LocalDateTime dataHora;

}