package com.lunarivet.service;

import com.lunarivet.entity.Internacao;

import com.lunarivet.exception.ResourceNotFoundException;

import com.lunarivet.repository.InternacaoRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

@RequiredArgsConstructor

public class InternacaoService {

    private final
    InternacaoRepository repository;

    public List<Internacao>

    listarTodos(){

        return repository.findAll();

    }

    public Internacao

    buscarPorId(

            Long id){

        return repository

                .findById(id)

                .orElseThrow(

                        () ->

                                new ResourceNotFoundException(

                                        "Internação não encontrada"

                                )

                );

    }

    public Internacao salvar(

            Internacao internacao){

        return repository

                .save(internacao);

    }

    public Internacao atualizar(

            Long id,

            Internacao dados){

        Internacao atual =

                buscarPorId(id);

        atual.setEntrada(

                dados.getEntrada());

        atual.setAlta(

                dados.getAlta());

        atual.setMotivo(

                dados.getMotivo());

        atual.setObservacoes(

                dados.getObservacoes());

        atual.setVeterinarioResponsavel(

                dados.getVeterinarioResponsavel());

        atual.setAtiva(

                dados.getAtiva());

        atual.setBaia(

                dados.getBaia());

        atual.setTratamento(

                dados.getTratamento());

        atual.setMedicamentos(

                dados.getMedicamentos());

        atual.setPet(

                dados.getPet());

        return repository.save(

                atual);

    }

    public void excluir(

            Long id){

        repository.deleteById(id);

    }

}