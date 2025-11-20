
package com.Api.MaterialEstocado.Controller;

import com.Api.MaterialEstocado.Data.EquipamentoEntity;
import com.Api.MaterialEstocado.Service.EquipamentoService;
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
@RequestMapping("/equipamento")
public class EquipamentoController {
    @Autowired
    EquipamentoService equipamentoService;
    
    @GetMapping("/listar")  
    public ResponseEntity<List>getAllEquipamento(){
        List<EquipamentoEntity> equipamentos=equipamentoService.listarTodosEquipamentos();
      return new ResponseEntity<>(equipamentos,HttpStatus.OK);
    }
     @GetMapping("/pesquisar/{id}")
    public ResponseEntity<EquipamentoEntity> getEquipamentoById(@PathVariable Integer id) {
        EquipamentoEntity equipamento = equipamentoService.getEquipamentoId(id);
        return new ResponseEntity<>(equipamento, HttpStatus.OK);
    }
      @PostMapping("/adicionar")
    public ResponseEntity<EquipamentoEntity> addEquipamento(@Valid @RequestBody EquipamentoEntity Equip) {
        EquipamentoEntity novoEquipamento = equipamentoService.CadastrarEquipamento(Equip);
        return new ResponseEntity<>(novoEquipamento, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<EquipamentoEntity> atualizarCategoria(@PathVariable Integer id, @Valid @RequestBody EquipamentoEntity equipamento) {
        EquipamentoEntity equipamentoAtualizada = equipamentoService.atualizarEquipamento(id, equipamento);
        return new ResponseEntity<>(equipamentoAtualizada, HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarEquipamento(@PathVariable Integer id) {
        equipamentoService.deletarEquipamento(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}