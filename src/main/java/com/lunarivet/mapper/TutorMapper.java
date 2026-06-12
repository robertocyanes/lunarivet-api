package com.lunarivet.mapper;

import com.lunarivet.dto.TutorRequestDTO;
import com.lunarivet.dto.TutorResponseDTO;
import com.lunarivet.entity.Tutor;

public class TutorMapper {

    public static Tutor toEntity(
            TutorRequestDTO dto) {

        Tutor tutor = new Tutor();

        tutor.setNome(dto.getNome());
        tutor.setCpf(dto.getCpf());
        tutor.setTelefone(dto.getTelefone());
        tutor.setEmail(dto.getEmail());

        return tutor;
    }

    public static TutorResponseDTO toDTO(
            Tutor tutor) {

        return TutorResponseDTO
                .builder()
                .id(tutor.getId())
                .nome(tutor.getNome())
                .cpf(tutor.getCpf())
                .telefone(tutor.getTelefone())
                .email(tutor.getEmail())
                .build();

    }

}