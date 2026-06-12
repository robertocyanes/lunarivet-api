package com.lunarivet.service;

import com.lunarivet.entity.Consulta;
import com.lunarivet.exception.ResourceNotFoundException;
import com.lunarivet.repository.ConsultaRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final ConsultaRepository repository;

    public Consulta salvar(Consulta consulta){

        return repository.save(consulta);

    }

    public List<Consulta> listar(){

        return repository.findAll();

    }

    public Consulta buscar(Long id){

        return repository.findById(id)

                .orElseThrow(() ->

                        new ResourceNotFoundException(

                                "Consulta não encontrada"

                        )

                );

    }

    public void excluir(Long id){

        repository.deleteById(id);

    }

}