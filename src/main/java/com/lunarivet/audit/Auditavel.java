package com.lunarivet.audit;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass

@Getter
@Setter
public abstract class Auditavel {

    private LocalDateTime criadoEm;

    private LocalDateTime atualizadoEm;

    private String criadoPor;

    private String atualizadoPor;

    @PrePersist
    public void prePersist(){

        criadoEm = LocalDateTime.now();

        atualizadoEm = LocalDateTime.now();

    }

    @PreUpdate
    public void preUpdate(){

        atualizadoEm = LocalDateTime.now();

    }

}