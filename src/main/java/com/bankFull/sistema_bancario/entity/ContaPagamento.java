package com.bankFull.sistema_bancario.entity;

import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity
public class ContaPagamento extends Conta {
    private Double limiteTransferencia;

    public ContaPagamento() {
        this.setTipo("Pagamento");
        this.limiteTransferencia = 4999.99;
    }

    public Double getLimiteTransferencia() {

        return limiteTransferencia;
    }

    public void setLimiteTransferencia(Double limiteTransferencia) {
        this.limiteTransferencia = limiteTransferencia;
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
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
    }

    public void realizarTransferencia(Double valor) {
        if (valor > this.limiteTransferencia) {
            throw new IllegalArgumentException("Transferência acima do limite.");
        }
        if (this.getSaldo() >= valor) {
            this.setSaldo(this.getSaldo() - valor);
            registrarTransacao("Transferência", valor);
        } else {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
    }

    public void realizarSaque(Double valor) {
        if (this.getSaldo() >= valor) {

            this.setSaldo(this.getSaldo() - valor);
            registrarTransacao("Saque", valor);
        } else {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
    }

     private void registrarTransacao(String tipo, Double valor) {
        Transacoes transacao = new Transacoes();
        transacao.setConta(this);
        transacao.setTipo(tipo);
        transacao.setValor(valor);
        transacao.setData(LocalDateTime.now());
        this.getTransacoes().add(transacao);
    }
}