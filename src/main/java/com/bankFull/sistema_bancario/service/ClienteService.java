package com.bankFull.sistema_bancario.service;

import com.bankFull.sistema_bancario.dto.responseDto.SaldoResponseDto;
import com.bankFull.sistema_bancario.entity.Cliente;
import com.bankFull.sistema_bancario.entity.Conta;
import com.bankFull.sistema_bancario.entity.ContaCorrente;
import com.bankFull.sistema_bancario.entity.ContaPagamento;
import com.bankFull.sistema_bancario.exception.ClienteCadastradoException;
import com.bankFull.sistema_bancario.repository.ClienteRepository;
import com.bankFull.sistema_bancario.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ContaRepository contaRepository;

    public Cliente cadastrarCliente(Cliente cliente) {
        if (!isValidCPF(cliente.getCpf()) || !isValidEmail(cliente.getEmail())) {
            throw new IllegalArgumentException("Ops! CPF ou Email inválidos.");
        }

        if (clienteRepository.findByCpf(cliente.getCpf()) != null) {
            throw new ClienteCadastradoException("Cliente já se encontra cadastrado!");
        }

        Cliente novoCliente;
        try {
            novoCliente = clienteRepository.save(cliente);
        } catch (DataIntegrityViolationException e) {
            throw new ClienteCadastradoException("Cliente já se encontra cadastrado!");
        }

        Conta conta;

        if (cliente.getRendaSalarial() < 2500.00) {
            ContaPagamento contaPagamento = new ContaPagamento();
            contaPagamento.setCliente(novoCliente);
            contaPagamento.setSaldo(0.0);
            contaPagamento.setTipo("Pagamento");
            conta = contaRepository.save(contaPagamento);
        } else {
            ContaCorrente contaCorrente = new ContaCorrente();
            contaCorrente.setCliente(novoCliente);
            contaCorrente.setSaldo(0.0);
            contaCorrente.setTipo("Corrente");
            conta = contaRepository.save(contaCorrente);
        }
        List<Conta> contas = new ArrayList<>();
        contas.add(conta);
        novoCliente.setContas(contas);

        return clienteRepository.save(novoCliente);
    }

    public Cliente loginCliente(String cpf, String senha) {
        Cliente cliente = clienteRepository.findByCpfAndSenha(cpf, senha);
        if (cliente == null) {
            throw new IllegalArgumentException("Ops! CPF ou Senha inválidos!");
        }
        return cliente;
    }

    private boolean isValidCPF(String cpf) {

        return cpf.matches("\\d{11}");
    }

    private boolean isValidEmail(String email) {

        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    public Cliente atualizarCliente(Long id, Cliente novosDados) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado na nossa base de dados."));

        cliente.setNome(novosDados.getNome());
        cliente.setEmail(novosDados.getEmail());
        cliente.setEndereco(novosDados.getEndereco());
        cliente.setRendaSalarial(novosDados.getRendaSalarial());

        return clienteRepository.save(cliente);
    }

    public Cliente buscarPorCpf(String cpf) {
        return clienteRepository.findByCpf(cpf);
    }

    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    public SaldoResponseDto consultarSaldo(Long contaId) {
        Conta conta = contaRepository.findById(contaId)
                .orElseThrow(() -> new IllegalArgumentException("Conta não encontrada"));

        Cliente cliente = conta.getCliente();

        SaldoResponseDto saldoResponseDto = new SaldoResponseDto();
        saldoResponseDto.setNomeCliente(cliente.getNome());
        saldoResponseDto.setSaldo(conta.getSaldo());
        saldoResponseDto.setTipoConta(conta.getTipo());

        if (conta instanceof ContaCorrente) {
            ContaCorrente contaCorrente = (ContaCorrente) conta;
            Double chequeEspecialUtilizado = contaCorrente.getChequeEspecial();
            if (contaCorrente.getSaldo() < 0) {
                chequeEspecialUtilizado += contaCorrente.getSaldo();
            }
            saldoResponseDto.setLimiteChequeEspecial(chequeEspecialUtilizado);
        } else {
            saldoResponseDto.setLimiteChequeEspecial(0.0);
        }

        return saldoResponseDto;
    }

}