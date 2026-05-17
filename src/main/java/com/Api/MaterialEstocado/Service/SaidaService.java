package com.Api.MaterialEstocado.Service;

import com.Api.MaterialEstocado.Data.EntradaRepository;
import com.Api.MaterialEstocado.Data.SaidaEntity;
import com.Api.MaterialEstocado.Data.SaidaRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaidaService {

    @Autowired
    private SaidaRepository saidaRepository;

    @Autowired
    private EntradaRepository entradaRepository;

    // CADASTRAR
    public SaidaEntity cadastrarSaida(SaidaEntity saida) {

        saida.setId(null);

        Integer entradas = entradaRepository.totalEntradas(
                saida.getEquipamento().getId()
        );

        Integer saidas = saidaRepository.totalSaidas(
                saida.getEquipamento().getId()
        );

        Integer estoqueAtual = entradas - saidas;

        if (saida.getQuantidade() > estoqueAtual) {
            throw new RuntimeException("Estoque insuficiente");
        }

        return saidaRepository.save(saida);
    }

    // ATUALIZAR
    public SaidaEntity atualizarSaida(Integer saidaId, SaidaEntity saidaRequest) {

        SaidaEntity saida = getSaidaId(saidaId);

        saida.setEquipamento(saidaRequest.getEquipamento());
        saida.setQuantidade(saidaRequest.getQuantidade());
        saida.setData(saidaRequest.getData());

        return saidaRepository.save(saida);
    }

    // BUSCAR POR ID
    public SaidaEntity getSaidaId(Integer saidaId) {
        return saidaRepository.findById(saidaId)
                .orElseThrow(() -> new RuntimeException("Saída não encontrada"));
    }

    // LISTAR
    public List<SaidaEntity> listarTodasSaidas() {
        return saidaRepository.findAll();
    }

    // DELETAR
    public void deletarSaidas(Integer saidaId) {

        SaidaEntity saida = getSaidaId(saidaId);

        saidaRepository.deleteById(saida.getId());
    }
}
