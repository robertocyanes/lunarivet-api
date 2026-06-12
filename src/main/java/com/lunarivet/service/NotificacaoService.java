package com.lunarivet.service;

import com.lunarivet.entity.Consulta;
import com.lunarivet.entity.Exame;
import com.lunarivet.entity.Notificacao;
import com.lunarivet.entity.Pagamento;
import com.lunarivet.entity.Vacina;

import com.lunarivet.repository.ConsultaRepository;
import com.lunarivet.repository.ExameRepository;
import com.lunarivet.repository.NotificacaoRepository;
import com.lunarivet.repository.PagamentoRepository;
import com.lunarivet.repository.VacinaRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificacaoService {

    private final NotificacaoRepository notificacaoRepository;

    private final ConsultaRepository consultaRepository;

    private final VacinaRepository vacinaRepository;

    private final ExameRepository exameRepository;

    private final PagamentoRepository pagamentoRepository;

    /*
    ==============================
    CRUD
    ==============================
    */

    public List<Notificacao> listarTodas() {

        return notificacaoRepository.findAll();

    }

    public List<Notificacao> listarNaoLidas() {

        return notificacaoRepository.findByLidaFalse();

    }

    public void marcarComoLida(Long id) {

        Notificacao notificacao =

                notificacaoRepository

                        .findById(id)

                        .orElseThrow(

                                () -> new RuntimeException(
                                        "Notificação não encontrada"
                                )

                        );

        notificacao.setLida(true);

        notificacaoRepository.save(
                notificacao
        );

    }

    /*
    ==============================
    ROTINAS AUTOMÁTICAS
    ==============================
    */

    @Scheduled(
            cron =
                    "0 */30 * * * *"
    )
    public void executarRotinas() {

        verificarConsultas();

        verificarVacinas();

        verificarExames();

        verificarPagamentos();

    }

    private void verificarConsultas() {

        LocalDate amanha =

                LocalDate.now()
                        .plusDays(1);

        consultaRepository

                .findAll()

                .forEach(

                        consulta -> {

                            if (

                                    consulta.getDataHora()
                                            != null

                                            &&

                                            consulta
                                                    .getDataHora()
                                                    .toLocalDate()

                                                    .equals(
                                                            amanha
                                                    )

                            ) {

                                criarNotificacao(

                                        "Consulta amanhã",

                                        consulta
                                                .getPet()
                                                .getNome()

                                                +

                                                " possui consulta agendada"

                                );

                            }

                        }

                );

    }

    private void verificarVacinas() {

        vacinaRepository

                .findAll()

                .forEach(

                        vacina -> {

                            if (

                                    vacina.getDataAplicacao()
                                            != null

                                            &&

                                            vacina
                                                    .getDataAplicacao()

                                                    .plusYears(1)

                                                    .isBefore(

                                                            LocalDate.now()
                                                                    .plusDays(15)

                                                    )

                            ) {

                                criarNotificacao(

                                        "Vacina próxima",

                                        vacina.getNome()

                                                +

                                                " próxima do vencimento"

                                );

                            }

                        }

                );

    }

    private void verificarExames() {

        exameRepository

                .findAll()

                .forEach(

                        exame -> {

                            if (

                                    exame.getResultado()
                                            == null

                                            ||

                                            exame.getResultado()
                                                    .isBlank()

                            ) {

                                criarNotificacao(

                                        "Exame pendente",

                                        exame.getNome()

                                                +

                                                " aguardando resultado"

                                );

                            }

                        }

                );

    }

    private void verificarPagamentos() {

        pagamentoRepository

                .findAll()

                .forEach(

                        pagamento -> {

                            if (

                                    Boolean.FALSE.equals(
                                            pagamento.getPago()
                                    )

                            ) {

                                criarNotificacao(

                                        "Pagamento pendente",

                                        "Pagamento de "

                                                +

                                                pagamento
                                                        .getTutor()
                                                        .getNome()

                                                +

                                                " está pendente"

                                );

                            }

                        }

                );

    }

    /*
    ==============================
    CRIAÇÃO
    ==============================
    */

    private void criarNotificacao(

            String titulo,

            String mensagem

    ) {

        Notificacao notificacao =

                Notificacao.builder()

                        .titulo(
                                titulo
                        )

                        .mensagem(
                                mensagem
                        )

                        .lida(
                                false
                        )

                        .dataCriacao(
                                LocalDateTime.now()
                        )

                        .build();

        notificacaoRepository.save(
                notificacao
        );

    }

}