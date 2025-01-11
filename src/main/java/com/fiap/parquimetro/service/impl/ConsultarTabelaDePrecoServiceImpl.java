package com.fiap.parquimetro.service.impl;

import com.fiap.parquimetro.repository.TabelaDePrecoRepository;
import com.fiap.parquimetro.service.ConsultarTabelaDePrecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsultarTabelaDePrecoServiceImpl implements ConsultarTabelaDePrecoService {

    private final TabelaDePrecoRepository tabelaDePrecoRepository;

    @Override
    public OutPut execute() {
        var tabelaDePrecos = this.tabelaDePrecoRepository.findAll();

        if (tabelaDePrecos.isEmpty())
            throw new RuntimeException("Nao ha tabela de precos configurada");

        var tabelaDePreco = tabelaDePrecos.getFirst();

        return new OutPut(
                tabelaDePreco.getValorPrimeiraHora(),
                tabelaDePreco.getValorHorasAdicionais(),
                tabelaDePreco.getQtdMinimaHorasPermitidas(),
                tabelaDePreco.getQtdMaximaHorasPermitidas()
        );
    }
}
