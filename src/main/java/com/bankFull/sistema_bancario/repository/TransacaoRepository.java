package com.bankFull.sistema_bancario.repository;

import com.bankFull.sistema_bancario.entity.Transacoes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacoes, Long> {
    List<Transacoes> findByContaClienteId(Long clienteId);
}