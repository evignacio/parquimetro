package com.fiap.parquimetro.service.impl;

import com.fiap.parquimetro.domain.entity.RegistroVeiculo;
import com.fiap.parquimetro.exception.ApplicationException;
import com.fiap.parquimetro.repository.RegistroVeiculoRepository;
import com.fiap.parquimetro.service.ConsultarRegularidadeVeiculoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Log4j2
@RequiredArgsConstructor
public class ConsultarRegularidadeVeiculoImpl implements ConsultarRegularidadeVeiculoService {

    private final RegistroVeiculoRepository registroVeiculoRepository;


    @Override
    public Output execute(String placaVeiculo) {
        log.info("Consulta de regularidade de veiculo placa - {}", placaVeiculo);
        AtomicReference<Output> resultado = new AtomicReference<>();
        var veiculo = registroVeiculoRepository.findAllByPlacaVeiculo(placaVeiculo).stream().max(Comparator.comparing(RegistroVeiculo::getDataRegistro));
        veiculo.ifPresentOrElse(registroVeiculo -> {
            var isVeiculoRegular = isVeiculoRegular(registroVeiculo);
            resultado.set(new Output(isVeiculoRegular, registroVeiculo.getPlacaVeiculo(), registroVeiculo.getDataLimitePermanencia()));
        }, () -> {
            throw new ApplicationException("Veiculo nao encontrado");
        });

        return resultado.get();
    }

    private Boolean isVeiculoRegular(RegistroVeiculo registroVeiculo) {
        log.info("Checando regularidade veiculo : {}", registroVeiculo.getId());
        var horarioChecagem = LocalDateTime.now(ZoneId.of("UTC-3"));
        return horarioChecagem.isBefore(registroVeiculo.getDataLimitePermanencia());
    }
}

