package com.lunarivet.config;

import lombok.RequiredArgsConstructor;

import org.springframework.scheduling.annotation
        .Scheduled;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificacaoScheduler {

    @Scheduled(
            fixedRate = 86400000
    )
    public void verificarVacinas(){

        System.out.println(
                "Executando rotina automática");

    }

}