package com.example.despesas.service;

import com.example.despesas.model.Despesas;
import com.example.despesas.repository.DespesasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DespasasServiceImpl implements DespesasService {

     @Autowired
     private DespesasRepository despesaRepository;


    @Override
    public Despesas salvar(Despesas despesa) throws Exception {
        return null;
    }

    @Override
    public List<Despesas> bucarTodos() {
        return despesaRepository.findAll();
    }

    @Override
    public List<Despesas> consultarDespesas() {
        return despesaRepository.findAll();
    }

    @Override
    public Despesas buscarPorId(Long id) throws Exception {
        return null;
    }

    @Override
    public Despesas lancarDespesa(Despesas despesa) {
        despesa.setStatus("Pendente");
        despesa.setDataDePagamento(null);

        return despesaRepository.save(despesa);
    }

    @Override
    public Despesas alterarDespesa(Despesas despesaExistente) throws Exception{
        if (despesaExistente.getStatus().equals("Pago")) {
            throw new Exception("Não é possível alterar uma despesa paga.");
        }

        despesaExistente.setCredor(despesaExistente.getCredor());
        despesaExistente.setValor(despesaExistente.getValor());
        despesaExistente.setDescricao(despesaExistente.getDescricao());


        return despesaRepository.save(despesaExistente);
    }

    }


