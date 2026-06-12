package com.lunarivet.security;

import com.lunarivet.entity.Usuario;
import com.lunarivet.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioDetailsService
        implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(
            String email
    ) throws UsernameNotFoundException {

        Usuario usuario =

                usuarioRepository

                        .findByEmail(email)

                        .orElseThrow(

                                () ->

                                        new UsernameNotFoundException(
                                                "Usuário não encontrado"
                                        )

                        );

        return new User(

                usuario.getEmail(),

                usuario.getSenha(),

                List.of(

                        new SimpleGrantedAuthority(

                                "ROLE_"
                                        + usuario.getRole().name()

                        )

                )

        );

    }

}