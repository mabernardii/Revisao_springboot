package com.example.idade;

public record IdadeResponse(
    int idadeAnos,
    int idadeMeses,
    int idadeDias,
    String classificacao
) {}