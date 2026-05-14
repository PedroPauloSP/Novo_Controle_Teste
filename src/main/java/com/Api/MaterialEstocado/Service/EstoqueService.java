/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Api.MaterialEstocado.Service;

import com.Api.MaterialEstocado.Data.EntradaRepository;
import com.Api.MaterialEstocado.Data.EquipamentoEntity;
import com.Api.MaterialEstocado.Data.EquipamentoRepository;
import com.Api.MaterialEstocado.Data.SaidaRepository;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class EstoqueService {

    private final EntradaRepository entradaRepository;
    private final SaidaRepository saidaRepository;
    private final EquipamentoRepository equipamentoRepository;

    public Map<String, Object> consultarEstoque(Integer equipamentoId) {

        EquipamentoEntity equipamento = equipamentoRepository
                .findById(equipamentoId)
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));

        Integer entradas = entradaRepository.totalEntradas(equipamentoId);
        Integer saidas = saidaRepository.totalSaidas(equipamentoId);

        int estoque = entradas - saidas;

        Map<String, Object> resposta = new HashMap<>();
        
        
        resposta.put("id", equipamento.getId());
        resposta.put("nome", equipamento.getNome());
        resposta.put("estoque", estoque);

        return resposta;
    }
}






/*
@Service
public class EstoqueService {

    @Autowired
    private EntradaRepository entradaRepository;

    @Autowired
    private SaidaRepository saidaRepository;

    public Integer calcularEstoque(Integer equipamentoId){

        Integer entradas =
                entradaRepository.totalEntradas(equipamentoId);

        Integer saidas =
                saidaRepository.totalSaidas(equipamentoId);

        return entradas - saidas;
    }
}*/