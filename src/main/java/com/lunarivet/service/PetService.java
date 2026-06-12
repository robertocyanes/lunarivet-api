package com.lunarivet.service;

import com.lunarivet.entity.Pet;
import com.lunarivet.entity.Tutor;

import com.lunarivet.exception.ResourceNotFoundException;

import com.lunarivet.repository.PetRepository;
import com.lunarivet.repository.TutorRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;

    private final TutorRepository tutorRepository;

    public List<Pet> listarTodos() {

        return petRepository.findAll();

    }

    public Pet buscarPorId(Long id) {

        return petRepository.findById(id)

                .orElseThrow(() ->

                        new ResourceNotFoundException(
                                "Pet não encontrado"
                        )

                );

    }

    public Pet salvar(Pet pet) {

        validarPet(pet);

        return petRepository.save(pet);

    }

    public Pet criar(
            Pet pet,
            Long tutorId
    ) {

        Tutor tutor =

                tutorRepository
                        .findById(tutorId)

                        .orElseThrow(() ->

                                new ResourceNotFoundException(
                                        "Tutor não encontrado"
                                )

                        );

        validarPet(pet);

        pet.setTutor(tutor);

        return petRepository.save(pet);

    }

    public Pet atualizar(
            Long id,
            Pet dados
    ) {

        Pet pet =
                buscarPorId(id);

        validarPet(dados);

        pet.setNome(
                dados.getNome()
        );

        pet.setEspecie(
                dados.getEspecie()
        );

        pet.setRaca(
                dados.getRaca()
        );

        pet.setPeso(
                dados.getPeso()
        );

        pet.setSexo(
                dados.getSexo()
        );

        pet.setCor(
                dados.getCor()
        );

        pet.setObservacoes(
                dados.getObservacoes()
        );

        pet.setDataNascimento(
                dados.getDataNascimento()
        );

        return petRepository.save(
                pet
        );

    }

    public void deletar(Long id) {

        Pet pet =
                buscarPorId(id);

        petRepository.delete(pet);

    }

    private void validarPet(Pet pet) {

        if (
                pet.getNome() == null
                        || pet.getNome().isBlank()
        ) {

            throw new IllegalArgumentException(
                    "Nome obrigatório"
            );

        }

        if (

                pet.getPeso() != null

                        &&

                        pet.getPeso() <= 0

        ) {

            throw new IllegalArgumentException(
                    "Peso inválido"
            );

        }

        if (

                pet.getDataNascimento() != null

                        &&

                        pet.getDataNascimento()
                                .isAfter(LocalDate.now())

        ) {

            throw new IllegalArgumentException(
                    "Data inválida"
            );

        }

    }

}