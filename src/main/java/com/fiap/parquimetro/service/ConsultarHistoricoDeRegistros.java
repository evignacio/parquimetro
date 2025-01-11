package com.fiap.parquimetro.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface ConsultarHistoricoDeRegistros {
    Page<Output> execute(LocalDateTime dataInicio, LocalDateTime dataFim, String placaVeiculo, Pageable pageable);

    record Output(LocalDateTime dataReservaVeiculo,
                  BigDecimal valorPrimeiraHora,
                  BigDecimal valorHorasAdicionais,
                  int qtdHorasReservadas,
                  BigDecimal valorTotalReserva,
                  LocalDateTime dataLimiteReservaVeiculo) {
    }
}
