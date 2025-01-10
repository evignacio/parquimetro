package com.fiap.parquimetro.service;

import com.fiap.parquimetro.service.dto.CriarRegistroVeiculoInput;
import com.fiap.parquimetro.service.dto.ConsultarTabelaDePrecoOutput;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface ParquimetroService {
    ConsultarTabelaDePrecoOutput consultarTabelaDePreco();
    Object criarRegistroVeiculo(CriarRegistroVeiculoInput input);
    Object consultarRegularidadeVeiculo(String placaVeiculo);
    List<Object> consultarHistoricoDeRegistros(LocalDateTime dataInicio, LocalDateTime dataFim, String placaVeiculo);
}
