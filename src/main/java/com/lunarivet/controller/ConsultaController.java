package com.lunarivet.controller;

import com.lunarivet.entity.Consulta;
import com.lunarivet.service.ConsultaService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService service;

    @GetMapping
    public List<Consulta> listar() {

        return service.listar();

    }

    @GetMapping("/{id}")
    public Consulta buscar(
            @PathVariable Long id
    ) {

        return service.buscar(id);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Consulta salvar(
            @RequestBody Consulta consulta
    ) {

        return service.salvar(consulta);

    }

    @PutMapping("/{id}")
    public Consulta atualizar(
            @PathVariable Long id,
            @RequestBody Consulta dados
    ) {

        Consulta consulta =
                service.buscar(id);

        consulta.setDataHora(
                dados.getDataHora()
        );

        consulta.setVeterinario(
                dados.getVeterinario()
        );

        consulta.setStatus(
                dados.getStatus()
        );

        consulta.setSintomas(
                dados.getSintomas()
        );

        consulta.setDiagnostico(
                dados.getDiagnostico()
        );

        consulta.setObservacoes(
                dados.getObservacoes()
        );

        consulta.setPet(
                dados.getPet()
        );

        return service.salvar(
                consulta
        );

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(
            @PathVariable Long id
    ) {

        service.excluir(id);

    }

}