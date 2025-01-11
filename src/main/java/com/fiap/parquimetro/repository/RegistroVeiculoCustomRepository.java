package com.fiap.parquimetro.repository;

import com.fiap.parquimetro.domain.entity.RegistroVeiculo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

public interface RegistroVeiculoCustomRepository {
    Page<RegistroVeiculo> findAll(LocalDateTime dataInicial, LocalDateTime dataFinal, String placaVeiculo, Pageable pageable);
}
