package com.lunarivet.dashboard;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/dashboard")

@RequiredArgsConstructor

public class DashboardController {

    private final DashboardService
            dashboardService;

    @GetMapping("/clinico")
    public DashboardClinicoDTO
    dashboardClinico(){

        return dashboardService
                .dashboardClinico();

    }

    @GetMapping("/financeiro")
    public DashboardFinanceiroDTO
    dashboardFinanceiro(){

        return dashboardService
                .dashboardFinanceiro();

    }

}