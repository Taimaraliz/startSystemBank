package com.bankFull.sistema_bancario.repository;

import com.bankFull.sistema_bancario.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {

}
