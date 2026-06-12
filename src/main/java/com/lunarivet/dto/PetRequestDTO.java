package com.lunarivet.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PetRequestDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String especie;

    private String raca;

    @NotNull
    private Double peso;

    private String sexo;

    @NotNull
    private Long tutorId;

}