package com.Api.MaterialEstocado.Service;

import com.Api.MaterialEstocado.Data.EntradaEntity;
import com.Api.MaterialEstocado.Data.EntradaRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntradaService {

    @Autowired
    private EntradaRepository entradaRepository;

    // CADASTRAR
    public EntradaEntity cadastrarEntrada(EntradaEntity entra){

        entra.setId(null);

        return entradaRepository.save(entra);
    }

    // ATUALIZAR
    public EntradaEntity atualizarEntrada(
            Integer entraId,
            EntradaEntity entradaRequest) {

        EntradaEntity entra = getEntradaId(entraId);

        if (entra == null) {
            throw new RuntimeException("Entrada não encontrada");
        }

        entra.setEquipamento(
                entradaRequest.getEquipamento()
        );

        entra.setQuantidade(
                entradaRequest.getQuantidade()
        );

        entra.setData(
                entradaRequest.getData()
        );

        return entradaRepository.save(entra);
    }

    // BUSCAR POR ID
    public EntradaEntity getEntradaId(Integer entraId){

        return entradaRepository
                .findById(entraId)
                .orElse(null);
    }

    // LISTAR
    public List<EntradaEntity> listarTodasEntradas(){

        return entradaRepository.findAll();
    }

    // DELETAR
    public void deletarEntrada(Integer entraId){

        EntradaEntity entra = getEntradaId(entraId);

        if (entra == null) {
            throw new RuntimeException("Entrada não encontrada");
        }

        entradaRepository.deleteById(entra.getId());
    }
}




/*
package com.Api.MaterialEstocado.Service;

import com.Api.MaterialEstocado.Data.EntradaEntity;
import com.Api.MaterialEstocado.Data.EntradaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntradaService {
     @Autowired
 EntradaRepository entradaRepository;
 
 public EntradaEntity cadastrarEntrada(EntradaEntity entra){
     entra.setId(null);
     
     entradaRepository.save(entra);
     return entra;
 }
    
    public EntradaEntity atualizarEtrada(Integer entraId, EntradaEntity entradaRequest) {

        EntradaEntity entra = getentradaId (entraId);
        entra.setRazaoSocial(entradaRequest.getRazaoSocial());
        entra.setCnpj(entradaRequest.getCnpj());
        entra.setTelefone(entradaRequest.getTelefone());
        entra.setEmail(entradaRequest.getEmail());

       

        entradaRepository.save(entra);

        return entra;

    }
     public EntradaEntity getentradaId(Integer entraId) { 

 return entradaRepository.findById(entraId).orElse(null);
 
// return funcionarioRepository.findById(funcId).orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado " + funcId)); 
 
     } 
  public List<EntradaEntity> listarTodasEtradas() { 
return entradaRepository.findAll(); 

} 

public void deletarEntrada(Integer entraId) { 
EntradaEntity entra = getentradaId(entraId); 

entradaRepository.deleteById(entra.getId()); 

} 
}
*/