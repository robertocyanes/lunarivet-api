package com.lunarivet.service;

import com.lunarivet.entity.Tutor;
import com.lunarivet.exception.ResourceNotFoundException;
import com.lunarivet.repository.TutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TutorService {

    private final TutorRepository repository;

    public List<Tutor> listarTodos() {

        return repository.findAll();
    }

    public Tutor buscarPorId(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Tutor não encontrado"));
    }

    public Tutor salvar(Tutor tutor) {

        return repository.save(tutor);
    }

    public Tutor atualizar(
            Long id,
            Tutor novo) {

        Tutor tutor = buscarPorId(id);

        tutor.setNome(novo.getNome());
        tutor.setCpf(novo.getCpf());
        tutor.setTelefone(novo.getTelefone());
        tutor.setEmail(novo.getEmail());

        return repository.save(tutor);
    }

    public void deletar(Long id) {

        repository.delete(buscarPorId(id));
    }

}