package com.lunarivet.relatorios.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RelatorioConsultaDTO {

    private String veterinario;

    private Long totalConsultas;

}