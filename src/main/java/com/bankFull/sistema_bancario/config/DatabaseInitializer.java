package com.bankFull.sistema_bancario.config;

import com.bankFull.sistema_bancario.repository.ClienteRepository;
import com.bankFull.sistema_bancario.repository.ContaRepository;
import com.bankFull.sistema_bancario.repository.TransacaoRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseInitializer implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DatabaseInitializer.class);

    private final ClienteRepository clienteRepository;
    private final ContaRepository contaRepository;
    private final TransacaoRepository transacaoRepository;

    public DatabaseInitializer(ClienteRepository clienteRepository, ContaRepository contaRepository, TransacaoRepository transacaoRepository) {
        this.clienteRepository = clienteRepository;
        this.contaRepository = contaRepository;
        this.transacaoRepository = transacaoRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        log.info("O Banco conectou !!!");
        log.info("Dados inseridos com sucesso no banco de dados!");
    }
}
