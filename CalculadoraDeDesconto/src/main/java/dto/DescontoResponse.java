package dto;

public record DescontoResponse(
    double valorOriginal,
    double valorDesconto,
    double valorFinal,
    String mensagem
) {}