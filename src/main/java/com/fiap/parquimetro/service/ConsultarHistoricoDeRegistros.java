package com.fiap.parquimetro.service;

import java.time.LocalDateTime;
import java.util.List;

public interface ConsultarHistoricoDeRegistros {
    List<Object> execute(LocalDateTime dataInicio, LocalDateTime dataFim, String placaVeiculo);
}
