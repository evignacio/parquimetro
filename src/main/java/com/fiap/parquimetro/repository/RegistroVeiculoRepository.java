package com.fiap.parquimetro.repository;

import com.fiap.parquimetro.domain.entity.RegistroVeiculo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistroVeiculoRepository extends MongoRepository<RegistroVeiculo, String>, RegistroVeiculoCustomRepository {

    Optional<RegistroVeiculo> findByPlacaVeiculo(String placaVeiculo);
}
