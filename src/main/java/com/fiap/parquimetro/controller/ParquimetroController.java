package com.fiap.parquimetro.controller;

import com.fiap.parquimetro.service.ConsultarTabelaDePrecoService;
import com.fiap.parquimetro.service.CriarRegistroVeiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/parquimetro")
public class ParquimetroController {

    private final ConsultarTabelaDePrecoService consultarTabelaDePrecoService;
    private final CriarRegistroVeiculoService criarRegistroVeiculo;

    @GetMapping("tabela-preco")
    public ResponseEntity<ConsultarTabelaDePrecoService.OutPut> consultarTabelaPreco() {
        return ResponseEntity.ok(this.consultarTabelaDePrecoService.execute());
    }

    @PostMapping("registro-veiculo")
    public ResponseEntity<CriarRegistroVeiculoService.Output> criarRegistroVeiculo(@RequestBody CriarRegistroVeiculoService.Input input) {
        return ResponseEntity.ok(this.criarRegistroVeiculo.execute(input));
    }
}
