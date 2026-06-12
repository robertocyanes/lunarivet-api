package com.lunarivet.dashboard;

import com.lunarivet.repository.*;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final PetRepository petRepository;

    private final TutorRepository tutorRepository;

    private final ConsultaRepository consultaRepository;

    private final PagamentoRepository pagamentoRepository;

    private final VacinaRepository vacinaRepository;

    private final ExameRepository exameRepository;

    public DashboardClinicoDTO dashboardClinico(){

        return DashboardClinicoDTO.builder()

                .totalPets(
                        petRepository.count()
                )

                .totalTutores(
                        tutorRepository.count()
                )

                .consultasHoje(
                        consultaRepository.count()
                )

                .vacinasPendentes(
                        vacinaRepository.count()
                )

                .cirurgiasAgendadas(
                        0L
                )

                .examesPendentes(
                        exameRepository.count()
                )

                .build();

    }

    public DashboardFinanceiroDTO dashboardFinanceiro(){

        long pagamentos =
                pagamentoRepository.count();

        BigDecimal total =
                BigDecimal.ZERO;

        BigDecimal ticket =
                pagamentos > 0
                        ? total.divide(
                        BigDecimal.valueOf(
                                pagamentos
                        ),
                        2,
                        RoundingMode.HALF_UP
                )
                        : BigDecimal.ZERO;

        return DashboardFinanceiroDTO
                .builder()

                .faturamentoMes(total)

                .faturamentoAno(total)

                .pendenciasFinanceiras(
                        BigDecimal.ZERO
                )

                .pagamentosRealizados(
                        pagamentos
                )

                .pagamentosPendentes(
                        0L
                )

                .ticketMedio(ticket)

                .build();

    }

}