package com.example.despesas.service;

import com.example.despesas.model.Despesas;

import java.util.List;

public interface DespesasService {

    Despesas salvar(Despesas despesa) throws Exception;

    List<Despesas> bucarTodos();

    List<Despesas> consultarDespesas();

    Despesas buscarPorId(Long id) throws Exception;


    Despesas lancarDespesa(Despesas despesa);

    Despesas alterarDespesa(Despesas despesaExistente) throws Exception;


}
