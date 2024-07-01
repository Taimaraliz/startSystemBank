package com.bankFull.sistema_bancario.exception;

public class SaldoInsuficienteException extends RuntimeException{

    public SaldoInsuficienteException(String message) {
        super(message);
    }
}