package com.example.despesas.controller;

import com.example.despesas.model.Despesas;
import com.example.despesas.service.DespesasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/despesas")
public class DespesasController {

    @Autowired
    private final DespesasService despesasService;

    public DespesasController(DespesasService despesasService) {
        this.despesasService = despesasService;
    }



    @PostMapping("/lancar")
    public ResponseEntity<Despesas> lançarDespesa(@RequestBody Despesas despesa) {
        Despesas despesaLancada = despesasService.lancarDespesa(despesa);
        return ResponseEntity.status(HttpStatus.CREATED).body(despesaLancada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Despesas> alterarDespesa(@PathVariable Long id, @RequestBody Despesas despesa) throws Exception {
        Despesas despesaAlterada = despesasService.buscarPorId(id);

        if (despesaAlterada != null) {
            despesaAlterada = despesasService.alterarDespesa(despesaAlterada);
            return ResponseEntity.ok(despesaAlterada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Despesas>> consultarDespesas() {
        List<Despesas> despesas = despesasService.bucarTodos();
        return ResponseEntity.ok(despesas);
    }

    @GetMapping("/por-status/{status}")
    public ResponseEntity<List<Despesas>> consultarDespesasPorStatus(@PathVariable String status) {
        List<Despesas> despesas = despesasService.consultarDespesasPorStatus(status);
        return ResponseEntity.ok(despesas);
    }




}

