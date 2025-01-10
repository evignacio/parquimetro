package com.fiap.parquimetro.domain.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document("tabelaDePreco")
public class TabelaDePreco extends Entity {
    @Id
    private String codigo;
    private BigDecimal valorPrimeiraHora;
    private BigDecimal valorHorasAdicionais;
    private int qtdMinimaHorasPermitidas;
    private int qtdMaximaHorasPermitidas;

    public TabelaDePreco() {
    }

    public int getQtdMinimaHorasPermitidas() {
        return qtdMinimaHorasPermitidas;
    }

    public void setQtdMinimaHorasPermitidas(int qtdMinimaHorasPermitidas) {
        this.qtdMinimaHorasPermitidas = qtdMinimaHorasPermitidas;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getValorPrimeiraHora() {
        return valorPrimeiraHora;
    }

    public void setValorPrimeiraHora(BigDecimal valorPrimeiraHora) {
        this.valorPrimeiraHora = valorPrimeiraHora;
    }

    public BigDecimal getValorHorasAdicionais() {
        return valorHorasAdicionais;
    }

    public void setValorHorasAdicionais(BigDecimal valorHorasAdicionais) {
        this.valorHorasAdicionais = valorHorasAdicionais;
    }

    public int getQtdMaximaHorasPermitidas() {
        return qtdMaximaHorasPermitidas;
    }

    public void setQtdMaximaHorasPermitidas(int qtdMaximaHorasPermitidas) {
        this.qtdMaximaHorasPermitidas = qtdMaximaHorasPermitidas;
    }
}
