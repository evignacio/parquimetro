package com.fiap.parquimetro.controller;

import com.fiap.parquimetro.service.ParquimetroService;
import com.fiap.parquimetro.service.dto.ConsultarTabelaDePrecoOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/parquimetro")
public class ParquimetroController {

    private final ParquimetroService parquimetroService;

    @GetMapping("tabela-preco")
    public ResponseEntity<ConsultarTabelaDePrecoOutput> consultarTabelaPreco() {
        return ResponseEntity.ok(this.parquimetroService.consultarTabelaDePreco());
    }
}
