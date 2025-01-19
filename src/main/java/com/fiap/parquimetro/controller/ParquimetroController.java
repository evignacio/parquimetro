package com.fiap.parquimetro.controller;

import com.fiap.parquimetro.service.ConsultarHistoricoDeRegistros;
import com.fiap.parquimetro.service.ConsultarRegularidadeVeiculoService;
import com.fiap.parquimetro.service.ConsultarTabelaDePrecoService;
import com.fiap.parquimetro.service.CriarRegistroVeiculoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequestMapping("/parquimetro")
public interface ParquimetroController {
    @Operation(summary = "Consultar tabela de precos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta realizada com sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ConsultarTabelaDePrecoService.OutPut.class))}),
    })
    @GetMapping("tabela-preco")
    ResponseEntity<ConsultarTabelaDePrecoService.OutPut> consultarTabelaPreco();

    @Operation(summary = "Registrar entrada de veiculo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Registro realizado com sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CriarRegistroVeiculoService.Output.class))}),
    })
    @PostMapping("registro-veiculos")
    ResponseEntity<CriarRegistroVeiculoService.Output> criarRegistroVeiculo(@RequestBody CriarRegistroVeiculoService.Input input);

    @Operation(summary = "Consultar regularidade de veiculo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta realizada com sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ConsultarRegularidadeVeiculoService.Output.class))}),
    })
    @GetMapping("consultar-regularidade-veiculo/{placaVeiculo}")
    ResponseEntity<ConsultarRegularidadeVeiculoService.Output> consultarRegularidadeVeiculo(@Parameter(description = "Placa do veiculo a ser consultado") String placaVeiculo);

    @Operation(summary = "Consultar historico de registros de veiculos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta realizada com sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ConsultarHistoricoDeRegistros.Output.class))}),
    })
    @GetMapping("registro-veiculos")
    ResponseEntity<Page<ConsultarHistoricoDeRegistros.Output>> consultarRegistroVeiculo(
            @RequestParam(value = "dataInicio", required = false) LocalDateTime dataInicio,
            @RequestParam(value = "dataFim", required = false) LocalDateTime dataFim,
            @RequestParam(value = "placaVeiculo", required = false) String placaVeiculo,
            Pageable pageable);
}
