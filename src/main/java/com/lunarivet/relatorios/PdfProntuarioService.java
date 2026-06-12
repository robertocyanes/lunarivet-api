package com.lunarivet.relatorios;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import com.lunarivet.entity.Prontuario;

import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class PdfProntuarioService {

    public byte[] gerar(
            Prontuario prontuario
    ) {

        try {

            Document document =
                    new Document();

            ByteArrayOutputStream output =
                    new ByteArrayOutputStream();

            PdfWriter.getInstance(
                    document,
                    output
            );

            document.open();

            document.add(
                    new Paragraph(
                            "LUNARIVET CLINICA VETERINARIA"
                    )
            );

            document.add(
                    new Paragraph(
                            "PRONTUARIO"
                    )
            );

            document.add(
                    new Paragraph(

                            "Pet: "

                                    +

                                    prontuario
                                            .getPet()
                                            .getNome()

                    )
            );

            document.add(
                    new Paragraph(

                            prontuario
                                    .getAnotacoesGerais()

                    )
            );

            document.close();

            return output.toByteArray();

        }

        catch(Exception ex){

            throw new RuntimeException(
                    ex.getMessage()
            );

        }

    }

}