
package com.Api.MaterialEstocado.Service;

import com.Api.MaterialEstocado.Data.CategoriaEntity;
import com.Api.MaterialEstocado.Data.CategoriaRepository;
import com.Api.MaterialEstocado.Data.EquipamentoEntity;
import com.Api.MaterialEstocado.Data.EquipamentoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipamentoService {

    @Autowired
    EquipamentoRepository equipamentoRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    public EquipamentoEntity CadastrarEquipamento(
            EquipamentoEntity Equip){

        Equip.setId(null);

        Integer categoriaId = Equip
                .getCategoria()
                .getId();

        CategoriaEntity categoria = categoriaRepository
                .findById(categoriaId)
                .orElseThrow(() ->
                        new RuntimeException("Categoria não encontrada"));

        Equip.setCategoria(categoria);

        equipamentoRepository.save(Equip);

        return Equip;
    }

    public EquipamentoEntity getEquipamentoId(Integer EquipId){
        return equipamentoRepository
                .findById(EquipId)
                .orElse(null);
    }

    public List<EquipamentoEntity> listarTodosEquipamentos(){
        return equipamentoRepository.findAll();
    }

    public void deletarEquipamento(Integer EquipId){

        EquipamentoEntity Equip = getEquipamentoId(EquipId);

        equipamentoRepository.deleteById(Equip.getId());
    }

    public EquipamentoEntity atualizarEquipamento(
            Integer EquipId,
            EquipamentoEntity equipamentoRequest){

        EquipamentoEntity Equip = getEquipamentoId(EquipId);

        Equip.setNome(equipamentoRequest.getNome());

        Integer categoriaId = equipamentoRequest
                .getCategoria()
                .getId();

        CategoriaEntity categoria = categoriaRepository
                .findById(categoriaId)
                .orElseThrow(() ->
                        new RuntimeException("Categoria não encontrada"));

        Equip.setCategoria(categoria);

        equipamentoRepository.save(Equip);

        return Equip;
    }
}
 /*
 public  ArrayList<EquipamentoEntity>buscarEquipamento(){
     EquipamentoService Equip = EquipamentoService()Equip.getEquipamentoId(EquipId);
 return null;
 }    */

     