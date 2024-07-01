package com.bankFull.sistema_bancario.controller;

import com.bankFull.sistema_bancario.dto.requesteDto.DepositoRequestDto;
import com.bankFull.sistema_bancario.dto.requesteDto.PagamentoRequestDto;
import com.bankFull.sistema_bancario.dto.requesteDto.SaqueRequestDto;
import com.bankFull.sistema_bancario.dto.requesteDto.TransferenciaRequestDto;
import com.bankFull.sistema_bancario.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

   /* @PostMapping("/pagamento/pix")
    public ResponseEntity<String> realizarPixPagamento(@RequestParam Long contaId, @RequestParam Double valor) {
        contaService.realizarPixPagamento(contaId, valor);
        return ResponseEntity.ok("Pix efetuado com Sucesso!");
    }*/

    @PostMapping("/corrente/pix")
    public ResponseEntity<String> realizarPixCorrente(@RequestParam Long contaId, @RequestParam Double valor) {
        contaService.realizarPixCorrente(contaId, valor);
        return ResponseEntity.ok("Pix efetuado com Sucesso!");
    }

    @PostMapping("/saque")
    public ResponseEntity<String> realizarSaque(@RequestBody SaqueRequestDto saqueRequestDto) {
        contaService.realizarSaque(saqueRequestDto.getContaId(), saqueRequestDto.getValor());
        return ResponseEntity.ok("Saque realizado com sucesso");
    }

    @PostMapping("/transferencia")
    public ResponseEntity<String>  realizarTransferencia(@RequestBody TransferenciaRequestDto transferenciaRequest) {
        contaService.realizarTransferencia(transferenciaRequest.getContaOrigemId(), transferenciaRequest.getContaDestinoId(), transferenciaRequest.getValor());
        return ResponseEntity.ok("Transferência realizada com Sucesso!");
    }

    @PostMapping("/deposito")
    public ResponseEntity<String> realizarDeposito(@RequestBody DepositoRequestDto depositoRequest) {
        contaService.realizarDeposito(depositoRequest.getContaId(), depositoRequest.getValor());
        return ResponseEntity.ok("Depósito realizado com sucesso!");
    }

    @PostMapping("/pagamento")
    public ResponseEntity<String> realizarPagamento(@RequestBody PagamentoRequestDto pagamentoRequest) {
        contaService.realizarPagamento(pagamentoRequest.getContaId(), pagamentoRequest.getValor());
        return ResponseEntity.ok("Pagamento realizado com sucesso!");
    }

}