package com.fiap.parquimetro.service;

import com.fiap.parquimetro.domain.enums.TipoPagamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface CriarRegistroVeiculoService {
    Output execute(Input input);

    record Input(String placaVeiculo, TipoPagamento tipoPagamento, int qtdHorasReserva) {
    }

    record Output(LocalDateTime dataReservaVeiculo,
                         BigDecimal valorPrimeiraHora,
                         BigDecimal valorHorasAdicionais,
                         int qtdHorasReservadas,
                         BigDecimal valorTotalReserva,
                         LocalDateTime dataLimiteReservaVeiculo) {
    }
}
