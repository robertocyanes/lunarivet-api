package com.lunarivet.service;

import com.lunarivet.entity.Prescricao;

import com.lunarivet.exception.ResourceNotFoundException;

import com.lunarivet.repository.PrescricaoRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import java.util.List;

@Service

@RequiredArgsConstructor

public class PrescricaoService {

    private final
    PrescricaoRepository repository;

    public Prescricao salvar(

            Prescricao prescricao){

        prescricao.setDataPrescricao(

                LocalDateTime.now()

        );

        return repository.save(

                prescricao

        );

    }

    public List<Prescricao>

    listar(){

        return repository.findAll();

    }

    public Prescricao buscar(

            Long id){

        return repository

                .findById(id)

                .orElseThrow(

                        ()->

                                new ResourceNotFoundException(

                                        "Prescrição não encontrada"

                                )

                );

    }

    public void excluir(

            Long id){

        repository.deleteById(id);

    }

}