package com.fiap.parquimetro.entity;

import com.fiap.parquimetro.enums.TipoPagamento;
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
}
