package com.dev1a.CalculadoraDeDesconto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dto.DescontoResponse;

import java.util.Map;

@RestController
@RequestMapping("/api/calculadora")
public class DescontoController {

    @PostMapping("/desconto")
    public ResponseEntity<?> calcularDesconto(@RequestBody Map<String, Double> payload) {
        
        double valorProduto = payload.getOrDefault("valorProduto", 0.0);
        double porcentagemDesconto = payload.getOrDefault("porcentagemDesconto", 0.0);

        if (valorProduto <= 0) {
            return ResponseEntity.badRequest().body("Erro: O valor do produto deve ser maior que zero.");
        }

        if (porcentagemDesconto < 0 || porcentagemDesconto > 50) {
            return ResponseEntity.badRequest().body("Erro: O desconto deve estar entre 0% e 50%.");
        }

        double valorDesconto = valorProduto * (porcentagemDesconto / 100);
        double valorFinal = valorProduto - valorDesconto;
        String mensagem = "";

        if (porcentagemDesconto > 30) {
            mensagem = "Desconto especial aplicado";
        }

        DescontoResponse resposta = new DescontoResponse(
            valorProduto, 
            valorDesconto, 
            valorFinal, 
            mensagem
        );

        return ResponseEntity.ok(resposta);
    }
}