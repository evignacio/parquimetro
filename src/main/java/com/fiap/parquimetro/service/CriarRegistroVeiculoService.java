package com.fiap.parquimetro.service;

import com.fiap.parquimetro.domain.enums.TipoPagamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface CriarRegistroVeiculoService {
    Output execute(Input input);

    record Input(String placaVeiculo, TipoPagamento tipoPagamento, int qtdHorasReserva) {
    }

    record Output(String placaVeiculo,
                  LocalDateTime dataReservaVeiculo,
                  LocalDateTime dataLimiteReservaVeiculo,
                  BigDecimal valorPrimeiraHora,
                  BigDecimal valorHorasAdicionais,
                  int qtdHorasReservadas,
                  BigDecimal valorTotalReserva,
                  TipoPagamento tipoPagamento
                  ) {
    }
}
