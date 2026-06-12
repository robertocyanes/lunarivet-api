package com.lunarivet.service;

import com.lunarivet.entity.Vacina;
import com.lunarivet.exception.ResourceNotFoundException;
import com.lunarivet.repository.VacinaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VacinaService {

    private final VacinaRepository repository;

    public List<Vacina> listarTodos() {

        return repository.findAll();
    }

    public Vacina buscarPorId(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Vacina não encontrada"));
    }

    public Vacina salvar(Vacina vacina) {

        return repository.save(vacina);
    }

    public void deletar(Long id) {

        repository.delete(buscarPorId(id));
    }

}