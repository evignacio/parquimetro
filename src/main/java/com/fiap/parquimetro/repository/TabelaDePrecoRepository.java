package com.fiap.parquimetro.repository;

import com.fiap.parquimetro.domain.entity.TabelaDePreco;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TabelaDePrecoRepository extends MongoRepository<TabelaDePreco, String> {
}
