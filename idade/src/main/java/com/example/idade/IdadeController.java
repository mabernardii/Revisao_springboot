package com.example.idade;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class IdadeController {

    @GetMapping("/converter/{anos}")
    public ResponseEntity<?> calcularIdade(@PathVariable int anos) {
        
        if (anos < 0 || anos > 120) {
            return ResponseEntity.badRequest()
                .body("Erro: A idade deve estar entre 0 e 120 anos.");
        }

        
        int meses = anos * 12;
        int dias = anos * 365;
        
        
        String status = (anos < 18) ? "menor de idade" : "maior de idade";

       
        return ResponseEntity.ok(new IdadeResponse(anos, meses, dias, status));
    }
}