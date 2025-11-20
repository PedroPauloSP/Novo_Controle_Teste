
package com.Api.MaterialEstocado.Service;

import com.Api.MaterialEstocado.Data.FornecedorEntity;
import com.Api.MaterialEstocado.Data.FornecedorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FornecedorService {
    
      @Autowired
    FornecedorRepository fornecedorRepository;
    
      public FornecedorEntity cadastrarFornecedor(FornecedorEntity fornecedor) {
 fornecedor.setId(null);

        fornecedorRepository.save(fornecedor);
        return fornecedor;
    }

    public FornecedorEntity atualizarFornecedor(Integer fornecedorId, FornecedorEntity fornecedorRequest) {

        FornecedorEntity fornecedor = getFornecedorId(fornecedorId);

        fornecedor.setRazaosocial(fornecedorRequest.getRazaosocial());

        fornecedor.setCnpj(fornecedorRequest.getCnpj());
        fornecedor.setEndereco(fornecedorRequest.getEndereco());

       
        fornecedorRepository.save(fornecedor);

        return fornecedor;

    }
     public FornecedorEntity getFornecedorId(Integer fornecedorId) { 

 return fornecedorRepository.findById(fornecedorId).orElse(null);
 
// return funcionarioRepository.findById(funcId).orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado " + funcId)); 
 
     } 
  public List<FornecedorEntity> listarTodosFornecedores() { 
return fornecedorRepository.findAll(); 

} 

public void deletarFornecedor(Integer fornecedorId) { 
FornecedorEntity fornecedor= getFornecedorId(fornecedorId); 

fornecedorRepository.deleteById(fornecedor.getId());

} 

    
}
