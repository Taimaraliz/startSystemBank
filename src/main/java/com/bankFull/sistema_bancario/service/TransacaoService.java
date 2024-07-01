package com.bankFull.sistema_bancario.service;

import com.bankFull.sistema_bancario.entity.Transacoes;
import com.bankFull.sistema_bancario.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public List<Transacoes> buscarTransacoesPorCliente(Long clienteId) {
        return transacaoRepository.findByContaClienteId(clienteId);
    }

}