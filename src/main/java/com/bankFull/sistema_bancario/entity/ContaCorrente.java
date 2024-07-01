package com.bankFull.sistema_bancario.entity;

import jakarta.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class ContaCorrente extends Conta {
    private Double chequeEspecial;

    public ContaCorrente() {
        this.setTipo("corrente");
    }

    public Double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(Double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public void realizarPagamento(Double valor) {
        if (this.getSaldo() >= valor) {
            this.setSaldo(this.getSaldo() - valor);
            registrarTransacao("Pagamento", valor);
        } else {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
    }

    public void realizarPix(Double valor) {
        if (this.getSaldo() >= valor) {
            this.setSaldo(this.getSaldo() - valor);
            registrarTransacao("Pix", valor);
        } else {
            throw new IllegalArgumentException("Ops! Saldo insuficiente.");
        }
    }

    public void realizarSaque(Double valor) {
        if (this.getSaldo() >= valor) {
            this.setSaldo(this.getSaldo() - valor);
            registrarTransacao("Saque", valor);
        } else {
            throw new IllegalArgumentException("Ops! Saldo insuficiente.");
        }
    }

    private void registrarTransacao(String tipo, Double valor) {
        Transacoes tansacoes = new Transacoes();
        tansacoes.setConta(this);
        tansacoes.setTipo(tipo);
        tansacoes.setValor(valor);
        tansacoes.setData(LocalDateTime.now());
        this.getTransacoes().add(tansacoes);
    }
}