package com.bankFull.sistema_bancario.dto.requesteDto;

public class SaqueRequestDto {
    private Long contaId;
    private Double valor;

    public Long getContaId() {
        return contaId;
    }

    public void setContaId(Long contaId) {
        this.contaId = contaId;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}