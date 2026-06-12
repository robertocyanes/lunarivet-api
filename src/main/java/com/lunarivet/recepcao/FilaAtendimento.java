package com.lunarivet.recepcao;

import com.lunarivet.entity.Pet;

import jakarta.persistence.*;

import lombok.*;

@Entity

@Table(name="fila")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class FilaAtendimento {

    @Id

    @GeneratedValue(

            strategy=

                    GenerationType.IDENTITY

    )

    private Long id;

    @ManyToOne

    @JoinColumn(

            name="pet_id"

    )

    private Pet pet;

    private Integer senha;

    private Boolean atendido;

    private String prioridade;

}