package com.Api.MaterialEstocado.Service;

import com.Api.MaterialEstocado.Data.ClienteEntity;
import com.Api.MaterialEstocado.Data.ClienteRepository;
import com.Api.MaterialEstocado.Data.EquipamentoEntity;
import com.Api.MaterialEstocado.Data.EquipamentoRepository;
import com.Api.MaterialEstocado.Data.SaidaEntity;
import com.Api.MaterialEstocado.Data.SaidaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaidaService {

    @Autowired
    SaidaRepository saidaRepository;

    @Autowired
    EquipamentoRepository equipamentoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    public SaidaEntity cadastrarSaida(SaidaEntity saida){

        saida.setId(null);

        Integer equipamentoId = saida
                .getEquipamento()
                .getId();

        EquipamentoEntity equipamento = equipamentoRepository
                .findById(equipamentoId)
                .orElseThrow(() ->
                        new RuntimeException("Equipamento não encontrado"));

        Integer clienteId = saida
                .getCliente()
                .getId();

        ClienteEntity cliente = clienteRepository
                .findById(clienteId)
                .orElseThrow(() ->
                        new RuntimeException("Cliente não encontrado"));

        saida.setEquipamento(equipamento);

        saida.setCliente(cliente);

        saidaRepository.save(saida);

        return saida;
    }

    public SaidaEntity atualizarSaida(
            Integer saidaId,
            SaidaEntity saidaRequest) {

        SaidaEntity saida = getsaidaId(saidaId);

        saida.setQuantidade(saidaRequest.getQuantidade());

        saida.setData(saidaRequest.getData());

        Integer equipamentoId = saidaRequest
                .getEquipamento()
                .getId();

        EquipamentoEntity equipamento = equipamentoRepository
                .findById(equipamentoId)
                .orElseThrow(() ->
                        new RuntimeException("Equipamento não encontrado"));

        Integer clienteId = saidaRequest
                .getCliente()
                .getId();

        ClienteEntity cliente = clienteRepository
                .findById(clienteId)
                .orElseThrow(() ->
                        new RuntimeException("Cliente não encontrado"));

        saida.setEquipamento(equipamento);

        saida.setCliente(cliente);

        saidaRepository.save(saida);

        return saida;
    }

    public SaidaEntity getsaidaId(Integer saidaId){

        return saidaRepository
                .findById(saidaId)
                .orElse(null);
    }

    public List<SaidaEntity> listarTodasSaidas(){

        return saidaRepository.findAll();
    }

    public void deletarSaidas(Integer saidaId){

        SaidaEntity saida = getsaidaId(saidaId);

        saidaRepository.deleteById(saida.getId());
    }
}