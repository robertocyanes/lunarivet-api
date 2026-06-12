package com.lunarivet.financeiro;

import com.lunarivet.entity.Pagamento;

import com.lunarivet.repository.PagamentoRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class FinanceiroService {

    private final PagamentoRepository repository;

    public FinanceiroResumoDTO resumo(){

        BigDecimal recebido =
                BigDecimal.ZERO;

        BigDecimal pendente =
                BigDecimal.ZERO;

        long pagos = 0;

        long naoPagos = 0;

        for(Pagamento p :

                repository.findAll()){

            if(Boolean.TRUE.equals(
                    p.getPago())){

                pagos++;

                recebido =
                        recebido.add(
                                p.getValor()
                        );

            }

            else{

                naoPagos++;

                pendente =
                        pendente.add(
                                p.getValor()
                        );

            }

        }

        return FinanceiroResumoDTO

                .builder()

                .totalRecebido(
                        recebido
                )

                .totalPendente(
                        pendente
                )

                .pagamentosRealizados(
                        pagos
                )

                .pagamentosPendentes(
                        naoPagos
                )

                .build();

    }

}