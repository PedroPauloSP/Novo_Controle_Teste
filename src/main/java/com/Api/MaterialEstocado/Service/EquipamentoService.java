
package com.Api.MaterialEstocado.Service;

import com.Api.MaterialEstocado.Data.EquipamentoEntity;
import com.Api.MaterialEstocado.Data.EquipamentoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipamentoService {
    @Autowired
    EquipamentoRepository equipamentoRepository;
    
 public EquipamentoEntity CadastrarEquipamento (EquipamentoEntity Equip){
     Equip.setId(null);
     
     equipamentoRepository.save(Equip);
     return Equip;
 }
 public EquipamentoEntity getEquipamentoId(Integer EquipId){
     return equipamentoRepository.findById(EquipId).orElse(null);
 }
 public List<EquipamentoEntity>listarTodosEquipamentos(){
     return equipamentoRepository.findAll();
 }
 public void deletarEquipamento(Integer EquipId){
     EquipamentoEntity Equip = getEquipamentoId(EquipId);
     equipamentoRepository.deleteById(Equip.getId());
 }
 public EquipamentoEntity atualizarEquipamento(Integer EquipId,EquipamentoEntity equipamentoRequest){
     EquipamentoEntity Equip = getEquipamentoId(EquipId);
     Equip.setNome(equipamentoRequest.getNome());
     equipamentoRepository.save(Equip);
     return Equip;
 }
}
     