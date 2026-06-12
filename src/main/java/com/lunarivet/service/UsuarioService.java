package com.lunarivet.service;

import com.lunarivet.entity.Usuario;
import com.lunarivet.exception.ResourceNotFoundException;
import com.lunarivet.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;

    public Usuario salvar(Usuario usuario){

        usuario.setSenha(
                passwordEncoder.encode(
                        usuario.getSenha()
                )
        );

        return repository.save(usuario);

    }

    public Usuario buscarPorEmail(String email){

        return repository.findByEmail(email)

                .orElseThrow(() ->

                        new ResourceNotFoundException(

                                "Usuário não encontrado"

                        )

                );

    }

    public List<Usuario> listar(){

        return repository.findAll();

    }

}