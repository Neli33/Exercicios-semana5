package com.example.despesas.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.math.BigDecimal;

@Data
@Entity
public class Despesas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String credor;


    @Column(name = "data_de_vencimento", nullable = false)
    private Date dataDeVencimento;

    @Column(name = "data_de_pagamento", nullable = false)
    private Date dataDePagamento;


    @Column(precision = 19, scale = 2, nullable = false)
    private BigDecimal valor;

    @Column(columnDefinition = "text")
    private String descricao;

    @Column(nullable = false)
    private String status = "Pendente";


    public void setDataDePagamento(LocalDate now) {
    }
}