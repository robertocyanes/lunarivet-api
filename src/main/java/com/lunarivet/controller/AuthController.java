package com.lunarivet.controller;

import com.lunarivet.dto.LoginRequestDTO;
import com.lunarivet.dto.LoginResponseDTO;
import com.lunarivet.security.JwtService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
            @RequestBody LoginRequestDTO request) {

        System.out.println("ENTROU NO LOGIN");

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getSenha()
                )
        );

        String token =
                jwtService.gerarToken(
                        request.getEmail()
                );

        return ResponseEntity.ok(
                new LoginResponseDTO(
                        token,
                        "Bearer",
                        null,
                        null,
                        request.getEmail(),
                        null
                )
        );
    }

}