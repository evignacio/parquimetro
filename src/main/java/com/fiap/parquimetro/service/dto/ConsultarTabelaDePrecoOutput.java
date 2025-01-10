package com.fiap.parquimetro.service.dto;

import java.math.BigDecimal;

public record ConsultarTabelaDePrecoOutput(BigDecimal valorPrimeiraHora, BigDecimal valorHorasAdicionas, int qtdMinimaHorasPermitidas, int qtdMaximaHorasPermitidas) {
}
