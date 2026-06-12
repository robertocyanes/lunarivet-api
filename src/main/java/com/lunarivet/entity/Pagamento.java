package com.lunarivet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pagamentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;

    private String metodoPagamento;

    private LocalDate dataPagamento;

    private Boolean pago;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

}