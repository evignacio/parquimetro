package com.fiap.parquimetro.service.impl;

import com.fiap.parquimetro.repository.RegistroVeiculoRepository;
import com.fiap.parquimetro.service.ConsultarHistoricoDeRegistros;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ConsultarHistoricoDeRegistrosImpl implements ConsultarHistoricoDeRegistros {

    private final RegistroVeiculoRepository registroVeiculoRepository;

    @Override
    public Page<Output> execute(LocalDateTime dataInicio, LocalDateTime dataFim, String placaVeiculo, Pageable pageable) {
        var registrosVeiculos = this.registroVeiculoRepository.findAll(dataInicio, dataFim, placaVeiculo, pageable);
        var registroVeiculoOutput = registrosVeiculos.get()
                .map(r ->
                        new Output(
                                r.getPlacaVeiculo(),
                                r.getDataRegistro(),
                                r.getDataLimitePermanencia(),
                                r.getPagamento().getValor(),
                                r.getPagamento().getTipo()
                        )
                )
                .toList();
        return new PageImpl<>(registroVeiculoOutput);
    }
}
