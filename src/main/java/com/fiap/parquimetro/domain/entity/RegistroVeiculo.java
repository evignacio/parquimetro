package com.fiap.parquimetro.domain.entity;

import com.fiap.parquimetro.domain.valueObject.Pagamento;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Getter
@Document("registroVeiculo")
public class RegistroVeiculo extends Entity {
    private final String placaVeiculo;
    private final LocalDateTime dataRegistro;
    private final LocalDateTime dataLimitePermanencia;
    private final Pagamento pagamento;
    @Id
    private String id;

    public RegistroVeiculo(String placaVeiculo, LocalDateTime dataRegistro, LocalDateTime dataLimitePermanencia, Pagamento pagamento) {
        this.placaVeiculo = placaVeiculo;
        this.dataRegistro = dataRegistro;
        this.dataLimitePermanencia = dataLimitePermanencia;
        this.pagamento = pagamento;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public LocalDateTime getDataLimitePermanencia() {
        return dataLimitePermanencia;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public String getId() {
        return id;
    }
}
