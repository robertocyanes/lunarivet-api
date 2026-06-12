package com.lunarivet.controller;

import com.lunarivet.entity.Pagamento;
import com.lunarivet.service.PagamentoService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    private final PagamentoService service;

    public PagamentoController(
            PagamentoService service){

        this.service = service;
    }

    @GetMapping
    public List<Pagamento> listar(){

        return service.listar();
    }

    @GetMapping("/{id}")
    public Pagamento buscar(
            @PathVariable Long id){

        return service.buscar(id);
    }

    @PostMapping
    public Pagamento salvar(
            @RequestBody Pagamento pagamento){

        return service.salvar(
                pagamento);
    }

    @PutMapping("/{id}")
    public Pagamento atualizar(
            @PathVariable Long id,

            @RequestBody Pagamento pagamento){

        return service.atualizar(
                id,
                pagamento);
    }

    @DeleteMapping("/{id}")
    public void deletar(
            @PathVariable Long id){

        service.deletar(id);
    }

}