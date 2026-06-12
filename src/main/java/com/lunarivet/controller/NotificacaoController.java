package com.lunarivet.controller;

import com.lunarivet.entity.Notificacao;
import com.lunarivet.service.NotificacaoService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/notificacoes")

@RequiredArgsConstructor

public class NotificacaoController {

    private final
    NotificacaoService
            notificacaoService;

    @GetMapping

    public List<Notificacao>
    listar(){

        return notificacaoService
                .listarTodas();

    }

    @GetMapping("/nao-lidas")

    public List<Notificacao>
    naoLidas(){

        return notificacaoService
                .listarNaoLidas();

    }

    @PutMapping("/{id}/ler")

    public void marcarComoLida(

            @PathVariable
            Long id

    ){

        notificacaoService
                .marcarComoLida(id);

    }

}