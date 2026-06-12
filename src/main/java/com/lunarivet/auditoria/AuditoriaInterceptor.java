package com.lunarivet.auditoria;

import jakarta.servlet.http.*;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import org.springframework.web.servlet
        .HandlerInterceptor;

@Component

@RequiredArgsConstructor

public class AuditoriaInterceptor
        implements HandlerInterceptor {

    private final
    AuditoriaService
            auditoriaService;

    @Override

    public void afterCompletion(

            HttpServletRequest request,

            HttpServletResponse response,

            Object handler,

            Exception ex

    ){

        String usuario =

                request
                        .getUserPrincipal()

                        != null

                        ?

                        request
                                .getUserPrincipal()
                                .getName()

                        :

                        "ANONIMO";

        auditoriaService
                .registrar(

                        usuario,

                        request
                                .getRequestURI(),

                        request
                                .getMethod(),

                        "REQUISICAO_API",

                        request
                                .getRemoteAddr(),

                        response
                                .getStatus()

                );

    }

}