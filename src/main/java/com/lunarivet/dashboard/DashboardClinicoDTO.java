package com.lunarivet.dashboard;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DashboardClinicoDTO {

    private Long totalPets;

    private Long totalTutores;

    private Long consultasHoje;

    private Long vacinasPendentes;

    private Long cirurgiasAgendadas;

    private Long examesPendentes;

}