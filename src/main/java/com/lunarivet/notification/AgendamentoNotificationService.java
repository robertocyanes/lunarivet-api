package com.lunarivet.notification;

import com.lunarivet.entity.Consulta;

import com.lunarivet.repository
        .ConsultaRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.scheduling
        .annotation.Scheduled;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service

@RequiredArgsConstructor

public class AgendamentoNotificationService {

    private final
    ConsultaRepository
            consultaRepository;

    private final
    EmailService
            emailService;

    @Scheduled(
            cron =
                    "0 0 8 * * *"
    )

    public void enviarLembretes(){

        consultaRepository

                .findAll()

                .stream()

                .filter(

                        consulta ->

                                consulta
                                        .getDataHora()

                                        != null

                                        &&

                                        consulta
                                                .getDataHora()
                                                .toLocalDate()

                                                .equals(
                                                        LocalDate.now()
                                                                .plusDays(1)
                                                )

                )

                .forEach(

                        this::enviarEmail

                );

    }

    private void enviarEmail(

            Consulta consulta

    ){

        String email =

                consulta
                        .getPet()
                        .getTutor()
                        .getEmail();

        String assunto =

                "Lembrete de consulta";

        String mensagem =

                "Olá "

                        +

                        consulta
                                .getPet()
                                .getTutor()
                                .getNome()

                        +

                        "\n\n"

                        +

                        "A consulta de "

                        +

                        consulta
                                .getPet()
                                .getNome()

                        +

                        " está agendada para "

                        +

                        consulta
                                .getDataHora()

                        +

                        "\n\n"

                        +

                        "Equipe LunariVet";

        emailService.enviar(

                email,

                assunto,

                mensagem

        );

    }

}