package com.fiap.parquimetro.domain.entity;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;

@Getter
@Document
public class RegistroVeiculo extends Entity {
    @Id
    private String id;
    private final String placaVeiculo;
    private final LocalDateTime dataRegistro;
    private final LocalDateTime dataLimitePermanencia;
    @DocumentReference
    private final Pagamento pagamento;

    public RegistroVeiculo(String placaVeiculo, LocalDateTime dataRegistro, LocalDateTime dataLimitePermanencia, Pagamento pagamento) {
        this.placaVeiculo = placaVeiculo;
        this.dataRegistro = dataRegistro;
        this.dataLimitePermanencia = dataLimitePermanencia;
        this.pagamento = pagamento;
    }
}
