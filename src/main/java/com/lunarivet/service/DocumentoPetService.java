package com.lunarivet.service;

import com.lunarivet.entity.DocumentoPet;
import com.lunarivet.entity.Pet;

import com.lunarivet.exception.ResourceNotFoundException;

import com.lunarivet.repository.DocumentoPetRepository;
import com.lunarivet.repository.PetRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.nio.file.*;

@Service
@RequiredArgsConstructor
public class DocumentoPetService {

    private final DocumentoPetRepository repository;

    private final PetRepository petRepository;

    private final String pastaUploads =
            "uploads/documentos/";

    public DocumentoPet upload(
            Long petId,
            MultipartFile arquivo
    ) throws IOException {

        Pet pet =

                petRepository
                        .findById(petId)

                        .orElseThrow(() ->

                                new ResourceNotFoundException(
                                        "Pet não encontrado"
                                )

                        );

        Files.createDirectories(
                Paths.get(
                        pastaUploads
                )
        );

        String nomeArquivo =

                System.currentTimeMillis()

                        +

                        "_"

                        +

                        arquivo.getOriginalFilename();

        Path caminho =

                Paths.get(
                        pastaUploads,
                        nomeArquivo
                );

        Files.copy(

                arquivo.getInputStream(),

                caminho,

                StandardCopyOption
                        .REPLACE_EXISTING

        );

        DocumentoPet documento =

                DocumentoPet.builder()

                        .pet(pet)

                        .nomeArquivo(
                                nomeArquivo
                        )

                        .tipoDocumento(
                                arquivo.getContentType()
                        )

                        .urlArquivo(
                                caminho.toString()
                        )

                        .build();

        return repository.save(
                documento
        );

    }

}