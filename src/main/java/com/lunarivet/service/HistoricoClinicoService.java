package com.lunarivet.service;

import com.lunarivet.entity.HistoricoClinico;
import com.lunarivet.repository.HistoricoClinicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricoClinicoService {

    private final HistoricoClinicoRepository repository;

    public HistoricoClinicoService(
            HistoricoClinicoRepository repository) {

        this.repository = repository;
    }

    public List<HistoricoClinico> listar() {
        return repository.findAll();
    }

    public HistoricoClinico buscar(Long id) {
        return repository.findById(id)
                .orElseThrow();
    }

    public HistoricoClinico salvar(
            HistoricoClinico historico) {

        return repository.save(historico);
    }

    public HistoricoClinico atualizar(
            Long id,
            HistoricoClinico historico) {

        historico.setId(id);

        return repository.save(historico);
    }

    public void deletar(Long id) {

        repository.deleteById(id);
    }
}