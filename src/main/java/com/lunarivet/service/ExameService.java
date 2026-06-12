package com.lunarivet.service;

import com.lunarivet.entity.Exame;
import com.lunarivet.repository.ExameRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExameService {

    private final ExameRepository repository;

    public List<Exame> listar() {

        return repository.findAll();

    }

    public Exame buscar(Long id) {

        return repository.findById(id)

                .orElseThrow();

    }

    public Exame salvar(
            Exame exame
    ) {

        return repository.save(
                exame
        );

    }

    public Exame atualizar(

            Long id,

            Exame dados

    ) {

        Exame exame =
                buscar(id);

        exame.setNome(
                dados.getNome()
        );

        exame.setDataExame(
                dados.getDataExame()
        );

        exame.setLaboratorio(
                dados.getLaboratorio()
        );

        exame.setResultado(
                dados.getResultado()
        );

        exame.setArquivoResultado(
                dados.getArquivoResultado()
        );

        exame.setPet(
                dados.getPet()
        );

        return repository.save(
                exame
        );

    }

    public void deletar(Long id) {

        repository.deleteById(id);

    }

}