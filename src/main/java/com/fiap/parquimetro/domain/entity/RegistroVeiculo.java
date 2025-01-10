package com.fiap.parquimetro.domain.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;

@Document
public class RegistroVeiculo extends Entity {
    private final String placaVeiculo;
    private final LocalDateTime dataRegistro;
    private final LocalDateTime dataLimitePermanencia;
    @DocumentReference
    private final Pagamento pagamento;
    @Id
    private String id;

    public RegistroVeiculo(String placaVeiculo, LocalDateTime dataRegistro, LocalDateTime dataLimitePermanencia, Pagamento pagamento) {
        this.placaVeiculo = placaVeiculo;
        this.dataRegistro = dataRegistro;
        this.dataLimitePermanencia = dataLimitePermanencia;
        this.pagamento = pagamento;
    }
}
