package com.lunarivet.relatorios;

import com.lunarivet.entity.Prontuario;
import com.lunarivet.repository.ProntuarioRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/relatorios")
@RequiredArgsConstructor
public class RelatorioController {

    private final ProntuarioRepository repository;

    private final PdfProntuarioService pdfService;

    @GetMapping(
            "/prontuario/{id}"
    )

    public ResponseEntity<byte[]>
    prontuario(
            @PathVariable Long id
    ) {

        Prontuario prontuario =

                repository.findById(id)
                        .orElseThrow();

        byte[] pdf =

                pdfService
                        .gerar(prontuario);

        return ResponseEntity.ok()

                .header(

                        HttpHeaders.CONTENT_DISPOSITION,

                        "attachment; filename=prontuario.pdf"

                )

                .contentType(
                        MediaType.APPLICATION_PDF
                )

                .body(pdf);

    }

}