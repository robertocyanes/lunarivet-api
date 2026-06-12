package com.lunarivet.controller;

import com.lunarivet.entity.DocumentoPet;

import com.lunarivet.service.DocumentoPetService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/documentos")

@RequiredArgsConstructor
public class DocumentoPetController {

    private final DocumentoPetService service;

    @PostMapping(
            value="/upload/{petId}",
            consumes="multipart/form-data"
    )

    @ResponseStatus(HttpStatus.CREATED)

    public DocumentoPet upload(

            @PathVariable
            Long petId,

            @RequestParam
            MultipartFile arquivo

    ) throws Exception {

        return service.upload(
                petId,
                arquivo);

    }

}