package com.example.despesas.repository;

import com.example.despesas.model.Despesas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DespesasRepository extends JpaRepository<Despesas, Long> {

    List<Despesas> findByStatus(String status);
}
