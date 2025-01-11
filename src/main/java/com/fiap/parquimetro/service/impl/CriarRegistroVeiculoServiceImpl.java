package com.fiap.parquimetro.service.impl;

import com.fiap.parquimetro.domain.valueObject.Pagamento;
import com.fiap.parquimetro.domain.entity.RegistroVeiculo;
import com.fiap.parquimetro.repository.RegistroVeiculoRepository;
import com.fiap.parquimetro.service.ConsultarTabelaDePrecoService;
import com.fiap.parquimetro.service.CriarRegistroVeiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CriarRegistroVeiculoServiceImpl implements CriarRegistroVeiculoService {

    private final ConsultarTabelaDePrecoService consultarTabelaDePrecoService;
    private final RegistroVeiculoRepository registroVeiculoRepository;

    @Override
    public Output execute(Input input) {
        ConsultarTabelaDePrecoService.OutPut tabelaDepreco = this.consultarTabelaDePrecoService.execute();

        if (input.qtdHorasReserva() < tabelaDepreco.qtdMinimaHorasPermitidas() ||
                input.qtdHorasReserva() > tabelaDepreco.qtdMaximaHorasPermitidas())
            throw new RuntimeException("Quantidade de horas da reserva maior que a quantidade permitida");

        var dataReservaVeiculo = LocalDateTime.now();

        this.salvarRegistroVeiculo(tabelaDepreco, input, dataReservaVeiculo);
        return new Output(
                input.placaVeiculo(),
                dataReservaVeiculo,
                calcularDataLimiteReservaVeiculo(dataReservaVeiculo, input),
                tabelaDepreco.valorPrimeiraHora(),
                tabelaDepreco.valorHorasAdicionas(),
                input.qtdHorasReserva(),
                calcularValorReserva(tabelaDepreco, input),
                input.tipoPagamento()
        );
    }

    private void salvarRegistroVeiculo(ConsultarTabelaDePrecoService.OutPut tabelaDepreco, Input input, LocalDateTime dataReservaVeiculo) {
        Pagamento pagamento = new Pagamento(
                input.tipoPagamento(),
                calcularValorReserva(tabelaDepreco, input),
                dataReservaVeiculo
        );
        RegistroVeiculo registroVeiculo = new RegistroVeiculo(
                input.placaVeiculo(),
                dataReservaVeiculo,
                calcularDataLimiteReservaVeiculo(dataReservaVeiculo, input),
                pagamento
        );

        this.registroVeiculoRepository.save(registroVeiculo);
    }

    private BigDecimal calcularValorReserva(ConsultarTabelaDePrecoService.OutPut tabelaDePreco, Input registroVeiculo) {
        return tabelaDePreco.valorPrimeiraHora()
                .add(calcularValorHorasAdicionais(tabelaDePreco, registroVeiculo));
    }

    private BigDecimal calcularValorHorasAdicionais(ConsultarTabelaDePrecoService.OutPut tabelaDePreco, Input registroVeiculo) {
        return tabelaDePreco.valorHorasAdicionas()
                .multiply(new BigDecimal(registroVeiculo.qtdHorasReserva()).subtract(BigDecimal.ONE));
    }

    private LocalDateTime calcularDataLimiteReservaVeiculo(LocalDateTime dataReservaVeiculo, Input registroVeiculo) {
        return dataReservaVeiculo.plusHours(registroVeiculo.qtdHorasReserva());
    }
}
