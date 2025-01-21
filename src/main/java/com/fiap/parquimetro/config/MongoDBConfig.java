package com.fiap.parquimetro.config;

import com.fiap.parquimetro.domain.entity.TabelaDePreco;
import com.fiap.parquimetro.repository.TabelaDePrecoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

@Configuration
public class MongoDBConfig {

    @Bean
    CommandLineRunner runner(TabelaDePrecoRepository tabelaDePrecoRepository) {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<TabelaDePreco>> typeReference = new TypeReference<List<TabelaDePreco>>() {};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/data/tabelaDePreco.json");
            List<TabelaDePreco> tabelaDePrecos = mapper.readValue(inputStream, typeReference);
            tabelaDePrecoRepository.saveAll(tabelaDePrecos);
            System.out.println("Data saved!");
        };
    }
}
