package com.fiap.parquimetro.repository;

import com.fiap.parquimetro.entity.RegistroVeiculo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegistroVeiculoRepository extends MongoRepository<RegistroVeiculo, String> {
}
