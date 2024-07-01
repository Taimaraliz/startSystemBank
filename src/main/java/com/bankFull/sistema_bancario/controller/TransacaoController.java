package com.bankFull.sistema_bancario.controller;

import com.bankFull.sistema_bancario.entity.Transacoes;
import com.bankFull.sistema_bancario.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping("/cliente/{clienteId}")
    public List<Transacoes> buscarTransacoesPorCliente(@PathVariable Long clienteId) {
        return transacaoService.buscarTransacoesPorCliente(clienteId);
    }
}