package com.bankFull.sistema_bancario.controller;

import com.bankFull.sistema_bancario.dto.responseDto.SaldoResponseDto;
import com.bankFull.sistema_bancario.entity.Cliente;
import com.bankFull.sistema_bancario.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cadastrar")
    public Cliente cadastrarCliente(@RequestBody Cliente cliente) {
        return clienteService.cadastrarCliente(cliente);

    }
     @GetMapping("/{cpf}")
    public Cliente buscarPorCpf(@PathVariable String cpf) {
        return clienteService.buscarPorCpf(cpf);
    }

    @PostMapping("/login")
    public Cliente loginCliente(@RequestBody Cliente cliente) {
        return clienteService.loginCliente(cliente.getCpf(), cliente.getSenha());
    }

    @PutMapping("/{id}")
    public Cliente atualizarCliente(@PathVariable Long id, @RequestBody Cliente novosDados) {
        return clienteService.atualizarCliente(id, novosDados);
    }

    @GetMapping("/{id}/saldo")
    public SaldoResponseDto consultarSaldo(@PathVariable Long id) {
        return clienteService.consultarSaldo(id);
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

}