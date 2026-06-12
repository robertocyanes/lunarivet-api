package com.lunarivet.auditoria;

import com.lunarivet.entity.LogSistema;

import com.lunarivet.repository
        .LogSistemaRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service

@RequiredArgsConstructor

public class AuditoriaService {

    private final
    LogSistemaRepository
            repository;

    public void registrar(

            String usuario,

            String endpoint,

            String metodo,

            String acao,

            String ip,

            Integer status

    ){

        LogSistema log =

                LogSistema.builder()

                        .usuario(usuario)

                        .endpoint(endpoint)

                        .metodoHttp(metodo)

                        .acao(acao)

                        .ip(ip)

                        .statusHttp(status)

                        .dataHora(
                                LocalDateTime.now()
                        )

                        .build();

        repository.save(log);

    }

}