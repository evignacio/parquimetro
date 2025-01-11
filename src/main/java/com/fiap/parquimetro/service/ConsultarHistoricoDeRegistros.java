package com.fiap.parquimetro.service;

import com.fiap.parquimetro.domain.enums.TipoPagamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface ConsultarHistoricoDeRegistros {
    Page<Output> execute(LocalDateTime dataInicio, LocalDateTime dataFim, String placaVeiculo, Pageable pageable);

    record Output(String placaVeiculo,
                  LocalDateTime dataReservaVeiculo,
                  LocalDateTime dataLimiteReservaVeiculo,
                  BigDecimal valorTotalReserva,
                  TipoPagamento tipoPagamento) {
    }
}
