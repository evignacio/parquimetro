package com.fiap.parquimetro.domain.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class RegistroVeiculo extends Entity {
    @Id
    private String id;
    private String placaVeiculo;
    private LocalDateTime dataRegistro;
    private LocalDateTime dataLimitePermanencia;

    @DBRef
    private Pagamento pagamento;
}
