package com.lunarivet.relatorios;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import com.lunarivet.entity.Exame;

import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class PdfExameService {

    public byte[] gerar(
            Exame exame
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
                            "RESULTADO DE EXAME"
                    )
            );

            document.add(
                    new Paragraph(
                            exame.getNome()
                    )
            );

            document.add(
                    new Paragraph(
                            exame.getResultado()
                    )
            );

            document.close();

            return output.toByteArray();

        }

        catch (Exception ex) {

            throw new RuntimeException(
                    ex.getMessage()
            );

        }

    }

}