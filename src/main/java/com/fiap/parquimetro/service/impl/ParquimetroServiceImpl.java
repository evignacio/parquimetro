package com.fiap.parquimetro.service.impl;

import com.fiap.parquimetro.repository.TabelaDePrecoRepository;
import com.fiap.parquimetro.service.ParquimetroService;
import com.fiap.parquimetro.service.dto.CriarRegistroVeiculoInput;
import com.fiap.parquimetro.service.dto.CriarRegistroVeiculoOutput;
import com.fiap.parquimetro.service.dto.ConsultarTabelaDePrecoOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ParquimetroServiceImpl implements ParquimetroService {

    private final TabelaDePrecoRepository tabelaDePrecoRepository;

    @Override
    public ConsultarTabelaDePrecoOutput consultarTabelaDePreco() {
        var tabelaDePrecos = this.tabelaDePrecoRepository.findAll();

        if (tabelaDePrecos.isEmpty())
            throw new RuntimeException("Nao ha tabela de precos configurada");

        var tabelaDePreco = tabelaDePrecos.getFirst();

        return new ConsultarTabelaDePrecoOutput(
                tabelaDePreco.getValorPrimeiraHora(),
                tabelaDePreco.getValorHorasAdicionais(),
                tabelaDePreco.getQtdMinimaHorasPermitidas(),
                tabelaDePreco.getQtdMaximaHorasPermitidas()
        );
    }

    @Override
    public Object criarRegistroVeiculo(CriarRegistroVeiculoInput input) {
        ConsultarTabelaDePrecoOutput tabelaDepreco = consultarTabelaDePreco();

        if (input.qtdHorasReserva() < tabelaDepreco.qtdMinimaHorasPermitidas() ||
                input.qtdHorasReserva() > tabelaDepreco.qtdMaximaHorasPermitidas())
            throw new RuntimeException("Quantidade de horas da reserva maior que a quantidade permitida");

        var dataReservaVeiculo = LocalDateTime.now();
        return new CriarRegistroVeiculoOutput(
                dataReservaVeiculo,
                tabelaDepreco.valorPrimeiraHora(),
                tabelaDepreco.valorHorasAdicionas(),
                input.qtdHorasReserva(),
                calcularValorReserva(tabelaDepreco, input),
                calcularDataLimiteReservaVeiculo(dataReservaVeiculo, input)
        );
    }

    private BigDecimal calcularValorReserva(ConsultarTabelaDePrecoOutput tabelaDePreco, CriarRegistroVeiculoInput registroVeiculo) {
        return tabelaDePreco.valorPrimeiraHora().add(calcularValorHorasAdicionais(tabelaDePreco, registroVeiculo));
    }

    private BigDecimal calcularValorHorasAdicionais(ConsultarTabelaDePrecoOutput tabelaDePreco, CriarRegistroVeiculoInput registroVeiculo) {
        return tabelaDePreco.valorPrimeiraHora().add(new BigDecimal(registroVeiculo.qtdHorasReserva()));
    }

    private LocalDateTime calcularDataLimiteReservaVeiculo(LocalDateTime dataReservaVeiculo, CriarRegistroVeiculoInput registroVeiculo) {
        return dataReservaVeiculo.plusHours(registroVeiculo.qtdHorasReserva());
    }

    @Override
    public Object consultarRegularidadeVeiculo(String placaVeiculo) {
        return null;
    }

    @Override
    public List<Object> consultarHistoricoDeRegistros(LocalDateTime dataInicio, LocalDateTime dataFim, String placaVeiculo) {
        return List.of();
    }
}
