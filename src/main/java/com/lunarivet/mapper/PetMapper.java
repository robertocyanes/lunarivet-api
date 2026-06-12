package com.lunarivet.mapper;

import com.lunarivet.dto.PetRequestDTO;
import com.lunarivet.dto.PetResponseDTO;
import com.lunarivet.entity.Pet;

public class PetMapper {

    private PetMapper() {
    }

    public static Pet toEntity(PetRequestDTO dto) {

        if (dto == null) {
            return null;
        }

        Pet pet = new Pet();

        pet.setNome(dto.getNome());
        pet.setEspecie(dto.getEspecie());
        pet.setRaca(dto.getRaca());
        pet.setPeso(dto.getPeso());
        pet.setSexo(dto.getSexo());

        return pet;
    }

    public static PetResponseDTO toDTO(Pet pet) {

        if (pet == null) {
            return null;
        }

        return PetResponseDTO.builder()
                .id(pet.getId())
                .nome(pet.getNome())
                .especie(pet.getEspecie())
                .raca(pet.getRaca())
                .peso(pet.getPeso())
                .sexo(pet.getSexo())
                .tutorNome(
                        pet.getTutor() != null
                                ? pet.getTutor().getNome()
                                : null
                )
                .build();
    }

}