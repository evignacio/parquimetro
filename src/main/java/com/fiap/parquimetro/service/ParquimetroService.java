package com.fiap.parquimetro.service;

import com.fiap.parquimetro.enums.TipoPagamento;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface ParquimetroService {
    Object registrarVeiculo(Object veiculoDTO, TipoPagamento tipoPagamento);
    Object consultarRegularidadeVeiculo(String placaVeiculo);
    List<Object> consultarHistoricoDeRegistros(LocalDateTime dataInicio, LocalDateTime dataFim, String placaVeiculo);
}
