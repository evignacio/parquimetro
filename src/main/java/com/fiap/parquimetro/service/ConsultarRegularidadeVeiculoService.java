package com.fiap.parquimetro.service;

import java.time.LocalDateTime;

public interface ConsultarRegularidadeVeiculoService {
    Output execute(String placaVeiculo);

    record Output(boolean regular,
                  String placaVeiculo, LocalDateTime horarioLimite) {
    }
}
