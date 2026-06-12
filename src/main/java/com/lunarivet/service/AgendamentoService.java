package com.lunarivet.service;

import com.lunarivet.entity.Agendamento;
import com.lunarivet.exception.ResourceNotFoundException;
import com.lunarivet.repository.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository repository;

    public Agendamento salvar(Agendamento agendamento) {

        return repository.save(agendamento);

    }

    public List<Agendamento> listar() {

        return repository.findAll();

    }

    public List<Agendamento> listarTodos() {

        return repository.findAll();

    }

    public Agendamento buscar(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Agendamento não encontrado"
                        )
                );

    }

    public Agendamento buscarPorId(Long id) {

        return buscar(id);

    }

    public Agendamento atualizar(Long id, Agendamento dados) {

        Agendamento existente = buscar(id);

        existente.setPet(dados.getPet());
        existente.setDataHora(dados.getDataHora());
        existente.setTipo(dados.getTipo());
        existente.setObservacao(dados.getObservacao());
        existente.setConfirmado(dados.getConfirmado());

        return repository.save(existente);

    }

    public void excluir(Long id) {

        repository.deleteById(id);

    }

    public void deletar(Long id) {

        excluir(id);

    }

}