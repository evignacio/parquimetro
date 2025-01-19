package com.fiap.parquimetro.repository.impl;

import com.fiap.parquimetro.domain.entity.RegistroVeiculo;
import com.fiap.parquimetro.repository.RegistroVeiculoCustomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class RegistroVeiculoCustomRepositoryImpl implements RegistroVeiculoCustomRepository {

    private final MongoTemplate mongoTemplate;

    @Override
    public Page<RegistroVeiculo> findAll(LocalDateTime dataInicial, LocalDateTime dataFinal, String placaVeiculo, Pageable pageable) {
        var criteria = new Criteria();

        if (dataInicial != null && dataFinal != null)
            criteria.andOperator(
                    Criteria.where("dataRegistro").gte(dataInicial),
                    Criteria.where("dataRegistro").lte(dataFinal)
            );

        if (placaVeiculo != null)
            criteria.and("placaVeiculo")
                    .is(placaVeiculo);

        List<RegistroVeiculo> registrosVeiculos = this.mongoTemplate.find(new Query(criteria).with(pageable), RegistroVeiculo.class);
        return PageableExecutionUtils.getPage(
                registrosVeiculos,
                pageable,
                () -> this.mongoTemplate.count(new Query(criteria), RegistroVeiculo.class)
        );
    }
}
