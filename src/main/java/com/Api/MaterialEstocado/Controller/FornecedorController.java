
package com.Api.MaterialEstocado.Controller;

import com.Api.MaterialEstocado.Data.FornecedorEntity;
import com.Api.MaterialEstocado.Service.FornecedorService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {
       @Autowired
    FornecedorService fornecedorService;
    
    @GetMapping("/listar")  
    public ResponseEntity<List>getAllFornecedor(){
        List<FornecedorEntity> fornecedores=fornecedorService.listarTodosFornecedores();
      return new ResponseEntity<>(fornecedores,HttpStatus.OK);
    }
     @GetMapping("/pesquisar/{id}")
    public ResponseEntity<FornecedorEntity> getFornecedorById(@PathVariable Integer id) {
        FornecedorEntity fornecedor = fornecedorService.getFornecedorId(id);
        return new ResponseEntity<>(fornecedor, HttpStatus.OK);
    }
      @PostMapping("/adicionar")
    public ResponseEntity<FornecedorEntity> addFornecedor(@Valid @RequestBody FornecedorEntity Forn) {
        FornecedorEntity novoFornecedor = fornecedorService.cadastrarFornecedor(Forn);
        return new ResponseEntity<>(novoFornecedor, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<FornecedorEntity> atualizarFornecedor(@PathVariable Integer id, @Valid @RequestBody FornecedorEntity Forn) {
        FornecedorEntity fornecedorAtualizada = fornecedorService.atualizarFornecedor(id, Forn);
        return new ResponseEntity<>(fornecedorAtualizada, HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarFornecedor(@PathVariable Integer id) {
        fornecedorService.deletarFornecedor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
