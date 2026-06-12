package com.lunarivet.relatorios;

import com.lunarivet.repository.*;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RelatorioService {

    private final PetRepository petRepository;

    private final ConsultaRepository consultaRepository;

    private final TutorRepository tutorRepository;

    public String gerarResumoSistema(){

        return """

                ===== LUNARIVET =====

                Pets cadastrados:

                %d

                Tutores:

                %d

                Consultas:

                %d

                """

                .formatted(

                        petRepository.count(),

                        tutorRepository.count(),

                        consultaRepository.count()

                );

    }

}