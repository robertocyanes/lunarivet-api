package com.lunarivet.relatorios;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import com.lunarivet.entity.Pagamento;

import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class PdfPagamentoService {

    public byte[] gerar(
            Pagamento pagamento
    ){

        try{

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
                            "COMPROVANTE"
                    )
            );

            document.add(
                    new Paragraph(
                            pagamento.getTutor()
                                    .getNome()
                    )
            );

            document.add(
                    new Paragraph(
                            pagamento.getValor()
                                    .toString()
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