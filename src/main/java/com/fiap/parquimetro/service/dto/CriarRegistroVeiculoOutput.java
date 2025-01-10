package com.fiap.parquimetro.service.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CriarRegistroVeiculoOutput(LocalDateTime dataReservaVeiculo,
                                         BigDecimal valorPrimeiraHora,
                                         BigDecimal valorHorasAdicionais,
                                         int qtdHorasReservadas,
                                         BigDecimal valorTotalReserva,
                                         LocalDateTime dataLimiteReservaVeiculo) {
}
