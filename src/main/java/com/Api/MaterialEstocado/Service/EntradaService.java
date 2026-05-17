package com.Api.MaterialEstocado.Service;

import com.Api.MaterialEstocado.Data.EntradaEntity;
import com.Api.MaterialEstocado.Data.EntradaRepository;
import com.Api.MaterialEstocado.Data.EquipamentoEntity;
import com.Api.MaterialEstocado.Data.EquipamentoRepository;
import com.Api.MaterialEstocado.Data.FornecedorEntity;
import com.Api.MaterialEstocado.Data.FornecedorRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntradaService {

    @Autowired
    private EntradaRepository entradaRepository;

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    // CADASTRAR
    public EntradaEntity cadastrarEntrada(EntradaEntity entra) {

        entra.setId(null);

        EquipamentoEntity equipamento = buscarEquipamento(entra.getEquipamento().getId());
        FornecedorEntity fornecedor = buscarFornecedor(entra.getFornecedor().getId());

        entra.setEquipamento(equipamento);
        entra.setFornecedor(fornecedor);

        return entradaRepository.save(entra);
    }

    // ATUALIZAR
    public EntradaEntity atualizarEntrada(Integer entraId, EntradaEntity entradaRequest) {

        EntradaEntity entra = getEntradaId(entraId);

        EquipamentoEntity equipamento = buscarEquipamento(entradaRequest.getEquipamento().getId());
        FornecedorEntity fornecedor = buscarFornecedor(entradaRequest.getFornecedor().getId());

        entra.setEquipamento(equipamento);
        entra.setFornecedor(fornecedor);
        entra.setQuantidade(entradaRequest.getQuantidade());
        entra.setData(entradaRequest.getData());

        return entradaRepository.save(entra);
    }

    // BUSCAR POR ID
    public EntradaEntity getEntradaId(Integer entraId) {
        return entradaRepository.findById(entraId)
                .orElseThrow(() -> new RuntimeException("Entrada não encontrada"));
    }

    // LISTAR
    public List<EntradaEntity> listarTodasEntradas() {
        return entradaRepository.findAll();
    }

    // DELETAR
    public void deletarEntrada(Integer entraId) {

        EntradaEntity entra = getEntradaId(entraId);

        entradaRepository.deleteById(entra.getId());
    }

    // MÉTODOS AUXILIARES (IMPORTANTE)
    private EquipamentoEntity buscarEquipamento(Integer id) {
        return equipamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));
    }

    private FornecedorEntity buscarFornecedor(Integer id) {
        return fornecedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
    }
}