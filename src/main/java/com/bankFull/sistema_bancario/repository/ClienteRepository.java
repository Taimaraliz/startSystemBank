package com.bankFull.sistema_bancario.repository;

import com.bankFull.sistema_bancario.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByCpf(String cpf);
    Cliente findByCpfAndSenha(String cpf, String senha);
}