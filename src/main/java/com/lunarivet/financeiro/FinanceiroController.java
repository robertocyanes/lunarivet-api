package com.lunarivet.financeiro;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/financeiro")
@RequiredArgsConstructor
public class FinanceiroController {

    private final FinanceiroService service;

    @GetMapping("/resumo")
    public FinanceiroResumoDTO resumo() {

        return service.resumo();

    }

}