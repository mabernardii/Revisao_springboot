package com.notasalunos.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AvaliacaoController {

    @PostMapping("/avaliar")
    public Aluno calcularAvaliacao(@RequestBody Aluno aluno) {
       
        double media = (aluno.getNota1() + aluno.getNota2() + aluno.getNota3() + aluno.getNota4()) / 4;
        aluno.setMedia(media);

        if (media >= 7) {
            aluno.setSituacao("Aprovado");
        } else if (media >= 5) {
            aluno.setSituacao("Recuperação");
        } else {
            aluno.setSituacao("Reprovado");
        }

        return aluno;
    }
}