
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
    public SaidaEntity cadastrarSaida(SaidaEntity saida){

        saida.setId(null);

        Integer entradas =
                entradaRepository.totalEntradas(
                        saida.getEquipamento().getId()
                );

        Integer saidas =
                saidaRepository.totalSaidas(
                        saida.getEquipamento().getId()
                );

        Integer estoqueAtual = entradas - saidas;

        // Verifica estoque
        if (saida.getQuantidade() > estoqueAtual) {

            throw new RuntimeException(
                    "Estoque insuficiente"
            );
        }

        return saidaRepository.save(saida);
    }

    // ATUALIZAR
    public SaidaEntity atualizarSaida(
            Integer saidaId,
            SaidaEntity saidaRequest) {

        SaidaEntity saida = getSaidaId(saidaId);

        if (saida == null) {
            throw new RuntimeException("Saída não encontrada");
        }

        saida.setEquipamento(
                saidaRequest.getEquipamento()
        );

        saida.setQuantidade(
                saidaRequest.getQuantidade()
        );

        return saidaRepository.save(saida);
    }

    // BUSCAR POR ID
    public SaidaEntity getSaidaId(Integer saidaId){

        return saidaRepository
                .findById(saidaId)
                .orElse(null);
    }

    // LISTAR
    public List<SaidaEntity> listarTodasSaidas(){

        return saidaRepository.findAll();
    }

    // DELETAR
    public void deletarSaidas(Integer saidaId){

        SaidaEntity saida = getSaidaId(saidaId);

        if (saida == null) {
            throw new RuntimeException("Saída não encontrada");
        }

        saidaRepository.deleteById(saida.getId());
    }
}




/*package com.Api.MaterialEstocado.Service;

import com.Api.MaterialEstocado.Data.SaidaEntity;
import com.Api.MaterialEstocado.Data.SaidaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaidaService {
     @Autowired
 SaidaRepository saidaRepository;
    
    public SaidaEntity cadastrarSaida(SaidaEntity saida){
     saida.setId(null);
     
     saidaRepository.save(saida);
     return saida;
 }
    
    public SaidaEntity atualizarSaida(Integer saidaId, SaidaEntity saidaRequest) {

        SaidaEntity saida = getsaidaId (saidaId);

        saida.setRazaoSocial(saidaRequest.getRazaoSocial());

        saida.setCnpj(saidaRequest.getCnpj());
        saida.setTelefone(saidaRequest.getTelefone());
        saida.setEmail(saidaRequest.getEmail());

       

        saidaRepository.save(saida);

        return saida;

    }
     public SaidaEntity getsaidaId(Integer saidaId) { 

 return saidaRepository.findById(saidaId).orElse(null);
 
// return funcionarioRepository.findById(funcId).orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado " + funcId)); 
 
     } 
  public List<SaidaEntity> listarTodasSaidas() { 
return saidaRepository.findAll(); 

} 

public void deletarSaidas(Integer saidaId) { 
SaidaEntity saida = getsaidaId(saidaId); 

saidaRepository.deleteById(saida.getId()); 

} 

}*/
