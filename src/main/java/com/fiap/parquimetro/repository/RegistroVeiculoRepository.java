package com.fiap.parquimetro.repository;

import com.fiap.parquimetro.domain.entity.RegistroVeiculo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroVeiculoRepository extends MongoRepository<RegistroVeiculo, String> {
}
