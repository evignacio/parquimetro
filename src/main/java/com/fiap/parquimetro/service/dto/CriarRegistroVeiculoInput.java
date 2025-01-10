package com.fiap.parquimetro.service.dto;

import com.fiap.parquimetro.domain.enums.TipoPagamento;

public record CriarRegistroVeiculoInput(String placaVeiculo, TipoPagamento tipoPagamento, int qtdHorasReserva) {
}
