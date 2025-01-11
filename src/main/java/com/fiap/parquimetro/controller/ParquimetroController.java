package com.fiap.parquimetro.controller;

import com.fiap.parquimetro.service.ConsultarHistoricoDeRegistros;
import com.fiap.parquimetro.service.ConsultarRegularidadeVeiculoService;
import com.fiap.parquimetro.service.ConsultarTabelaDePrecoService;
import com.fiap.parquimetro.service.CriarRegistroVeiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/parquimetro")
public class ParquimetroController {

    private final ConsultarTabelaDePrecoService consultarTabelaDePrecoService;
    private final CriarRegistroVeiculoService criarRegistroVeiculo;
    private final ConsultarHistoricoDeRegistros consultarHistoricoDeRegistros;
    private final ConsultarRegularidadeVeiculoService consultarRegularidadeVeiculoService;

    @GetMapping("tabela-preco")

    public ResponseEntity<ConsultarTabelaDePrecoService.OutPut> consultarTabelaPreco() {
        return ResponseEntity.ok(this.consultarTabelaDePrecoService.execute());
    }

    @PostMapping("registro-veiculo")
    public ResponseEntity<CriarRegistroVeiculoService.Output> criarRegistroVeiculo(@RequestBody CriarRegistroVeiculoService.Input input) {
        return ResponseEntity.ok(this.criarRegistroVeiculo.execute(input));
    }

    @GetMapping("consultar-regularidade-veiculo")
    public ResponseEntity<ConsultarRegularidadeVeiculoService.Output> consultarRegularidadeVeiculo(String input) {
        return ResponseEntity.ok(this.consultarRegularidadeVeiculoService.execute(input));
    }

    @GetMapping("registro-veiculo")
    public ResponseEntity<Page<ConsultarHistoricoDeRegistros.Output>> consultarRegistroVeiculo(
            @RequestParam(value = "dataInicio", required = false) LocalDateTime dataInicio,
            @RequestParam(value = "dataFim", required = false) LocalDateTime dataFim,
            @RequestParam(value = "placaVeiculo", required = false) String placaVeiculo,
            Pageable pageable) {
        return ResponseEntity.ok(this.consultarHistoricoDeRegistros.execute(dataInicio, dataFim, placaVeiculo, pageable));
    }
}
