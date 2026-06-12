package com.lunarivet.repository;

import com.lunarivet.entity.LogSistema;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LogSistemaRepository
        extends JpaRepository<
        LogSistema,
        Long>{

}