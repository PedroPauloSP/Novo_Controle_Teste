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



