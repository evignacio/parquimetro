package com.fiap.parquimetro.service;

import java.math.BigDecimal;

public interface ConsultarTabelaDePrecoService {
    OutPut execute();

    record OutPut(BigDecimal valorPrimeiraHora, BigDecimal valorHorasAdicionas, int qtdMinimaHorasPermitidas,
                  int qtdMaximaHorasPermitidas) {
    }
}
