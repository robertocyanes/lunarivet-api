package com.lunarivet.service;

import com.lunarivet.entity.Cirurgia;
import com.lunarivet.exception.ResourceNotFoundException;
import com.lunarivet.repository.CirurgiaRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CirurgiaService {

    private final CirurgiaRepository repository;

    public List<Cirurgia> listarTodos() {

        return repository.findAll();

    }

    public Cirurgia buscarPorId(Long id) {

        return repository.findById(id)

                .orElseThrow(

                        () -> new ResourceNotFoundException(

                                "Cirurgia não encontrada"

                        )

                );

    }

    public Cirurgia salvar(
            Cirurgia cirurgia
    ) {

        return repository.save(
                cirurgia
        );

    }

    public Cirurgia atualizar(

            Long id,

            Cirurgia dados

    ) {

        Cirurgia atual =
                buscarPorId(id);

        atual.setProcedimento(
                dados.getProcedimento()
        );

        atual.setDataCirurgia(
                dados.getDataCirurgia()
        );

        atual.setVeterinario(
                dados.getVeterinario()
        );

        atual.setObservacoes(
                dados.getObservacoes()
        );

        atual.setCusto(
                dados.getCusto()
        );

        atual.setRealizada(
                dados.getRealizada()
        );

        atual.setPet(
                dados.getPet()
        );

        return repository.save(
                atual
        );

    }

    public void excluir(Long id) {

        repository.deleteById(
                id
        );

    }

}