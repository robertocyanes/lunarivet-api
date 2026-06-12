package com.lunarivet.service;

import com.lunarivet.entity.Pagamento;
import com.lunarivet.exception.ResourceNotFoundException;
import com.lunarivet.repository.PagamentoRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PagamentoService {

    private final PagamentoRepository repository;

    public List<Pagamento> listar() {

        return repository.findAll();

    }

    public Pagamento buscar(Long id) {

        return repository.findById(id)

                .orElseThrow(() ->

                        new ResourceNotFoundException(
                                "Pagamento não encontrado"
                        )
                );

    }

    public Pagamento salvar(Pagamento pagamento) {

        return repository.save(pagamento);

    }

    public Pagamento atualizar(
            Long id,
            Pagamento dados
    ) {

        Pagamento pagamento =
                buscar(id);

        pagamento.setValor(
                dados.getValor()
        );

        pagamento.setMetodoPagamento(
                dados.getMetodoPagamento()
        );

        pagamento.setDataPagamento(
                dados.getDataPagamento()
        );

        pagamento.setPago(
                dados.getPago()
        );

        pagamento.setTutor(
                dados.getTutor()
        );

        return repository.save(
                pagamento
        );

    }

    public void deletar(Long id) {

        buscar(id);

        repository.deleteById(id);

    }

}