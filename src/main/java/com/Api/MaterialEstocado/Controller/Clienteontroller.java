
package com.Api.MaterialEstocado.Controller;


import com.Api.MaterialEstocado.Data.ClienteEntity;
import com.Api.MaterialEstocado.Service.ClienteService;

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
@RequestMapping("/cliente")
public class Clienteontroller {
@Autowired
ClienteService clienteService;
    
    @GetMapping("/listar")  
    public ResponseEntity<List>getAllCliente(){
        List<ClienteEntity> clientes = clienteService.listarTodosClientes();
      return new ResponseEntity<>(clientes,HttpStatus.OK);
    }
     @GetMapping("/pesquisar/{id}")
    public ResponseEntity<ClienteEntity> getClienteById(@PathVariable Integer id) {
        ClienteEntity cliente = clienteService.getClienteId(id);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }
      @PostMapping("/adicionar")
    public ResponseEntity<ClienteEntity> addCliente(@Valid @RequestBody ClienteEntity cliente) {
       ClienteEntity novoCliente = clienteService.cadastrarCliente(cliente);
      //  return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
      return new ResponseEntity<>(novoCliente,HttpStatus.CREATED);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ClienteEntity> atualizarCliente(@PathVariable Integer id, @Valid @RequestBody ClienteEntity cliente) {
        ClienteEntity clienteAtualizada = clienteService.atualizarCliente(id, cliente);
        return new ResponseEntity<>(clienteAtualizada, HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Integer id) {
        clienteService.deletarCliente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

