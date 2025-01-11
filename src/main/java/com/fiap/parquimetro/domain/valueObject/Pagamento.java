package com.fiap.parquimetro.domain.valueObject;

import com.fiap.parquimetro.domain.enums.TipoPagamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pagamento {
    private TipoPagamento tipo;
    private BigDecimal valor;
    private LocalDateTime data;

    public Pagamento(TipoPagamento tipo, BigDecimal valor, LocalDateTime data) {
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
    }

    public TipoPagamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoPagamento tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
