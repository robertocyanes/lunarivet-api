package com.lunarivet.service;

import com.lunarivet.entity.Prontuario;

import com.lunarivet.exception.ResourceNotFoundException;

import com.lunarivet.repository.ProntuarioRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProntuarioService {

    private final ProntuarioRepository repository;

    public Prontuario salvar(

            Prontuario prontuario){

        return repository.save(prontuario);

    }

    public Prontuario buscarPorPet(

            Long petId){

        return repository

                .findByPetId(petId)

                .orElseThrow(() ->

                        new ResourceNotFoundException(

                                "Prontuário não encontrado"

                        )

                );

    }

}