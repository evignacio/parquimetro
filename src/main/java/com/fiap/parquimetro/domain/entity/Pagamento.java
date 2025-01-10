package com.fiap.parquimetro.domain.entity;

import com.fiap.parquimetro.domain.enums.TipoPagamento;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document
public class Pagamento extends Entity {
    @Id
    private String id;
    private TipoPagamento tipo;
    private BigDecimal valor;
    private LocalDateTime data;

    public Pagamento(TipoPagamento tipo, BigDecimal valor, LocalDateTime data) {
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
    }
}
