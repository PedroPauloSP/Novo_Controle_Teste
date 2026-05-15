
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
    EntradaRepository entradaRepository;

    @Autowired
    EquipamentoRepository equipamentoRepository;

    @Autowired
    FornecedorRepository fornecedorRepository;

    public EntradaEntity cadastrarEntrada(EntradaEntity entra){

        entra.setId(null);

        Integer equipamentoId = entra
                .getEquipamento()
                .getId();

        EquipamentoEntity equipamento = equipamentoRepository
                .findById(equipamentoId)
                .orElseThrow(() ->
                        new RuntimeException("Equipamento não encontrado"));

        Integer fornecedorId = entra
                .getFornecedor()
                .getId();

        FornecedorEntity fornecedor = fornecedorRepository
                .findById(fornecedorId)
                .orElseThrow(() ->
                        new RuntimeException("Fornecedor não encontrado"));

        entra.setEquipamento(equipamento);
        entra.setFornecedor(fornecedor);

        entradaRepository.save(entra);

        return entra;
    }

    public EntradaEntity atualizarEntrada(
            Integer entraId,
            EntradaEntity entradaRequest) {

        EntradaEntity entra = getentradaId(entraId);

        entra.setQuantidade(entradaRequest.getQuantidade());

        entra.setData(entradaRequest.getData());

        Integer equipamentoId = entradaRequest
                .getEquipamento()
                .getId();

        EquipamentoEntity equipamento = equipamentoRepository
                .findById(equipamentoId)
                .orElseThrow(() ->
                        new RuntimeException("Equipamento não encontrado"));

        Integer fornecedorId = entradaRequest
                .getFornecedor()
                .getId();

        FornecedorEntity fornecedor = fornecedorRepository
                .findById(fornecedorId)
                .orElseThrow(() ->
                        new RuntimeException("Fornecedor não encontrado"));

        entra.setEquipamento(equipamento);

        entra.setFornecedor(fornecedor);

        entradaRepository.save(entra);

        return entra;
    }

    public EntradaEntity getentradaId(Integer entraId){

        return entradaRepository
                .findById(entraId)
                .orElse(null);
    }

    public List<EntradaEntity> listarTodasEntradas(){

        return entradaRepository.findAll();
    }

    public void deletarEntrada(Integer entraId){

        EntradaEntity entra = getentradaId(entraId);

        entradaRepository.deleteById(entra.getId());
    }
}