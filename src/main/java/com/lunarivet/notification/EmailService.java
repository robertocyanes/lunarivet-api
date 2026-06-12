package com.lunarivet.notification;

import lombok.RequiredArgsConstructor;

import org.springframework.mail
        .SimpleMailMessage;

import org.springframework.mail
        .javamail
        .JavaMailSender;

import org.springframework.stereotype.Service;

@Service

@RequiredArgsConstructor

public class EmailService {

    private final
    JavaMailSender
            sender;

    public void enviar(

            String destino,

            String assunto,

            String mensagem

    ){

        SimpleMailMessage email =
                new SimpleMailMessage();

        email.setTo(
                destino
        );

        email.setSubject(
                assunto
        );

        email.setText(
                mensagem
        );

        sender.send(
                email
        );

    }

}