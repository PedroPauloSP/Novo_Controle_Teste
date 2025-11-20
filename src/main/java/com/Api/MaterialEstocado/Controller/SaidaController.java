
package com.Api.MaterialEstocado.Controller;

import com.Api.MaterialEstocado.Data.SaidaEntity;
import com.Api.MaterialEstocado.Service.SaidaService;
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
@RequestMapping("/saida")
public class SaidaController {
     @Autowired
    SaidaService saidaService;
    
    @GetMapping("/listar")  
    public ResponseEntity<List>getAllSaida(){
        List<SaidaEntity> saida=saidaService.listarTodasSaidas();
      return new ResponseEntity<>(saida,HttpStatus.OK);
    }
     @GetMapping("/pesquisar/{id}")
    public ResponseEntity<SaidaEntity> getSaidaById(@PathVariable Integer id) {
       SaidaEntity saida = saidaService.getsaidaId(id);
        return new ResponseEntity<>(saida, HttpStatus.OK);
    }
      @PostMapping("/adicionar")
    public ResponseEntity<SaidaEntity> addSaida(@Valid @RequestBody SaidaEntity Saida) {
        SaidaEntity novaSaida = saidaService.cadastrarSaida(Saida);
        return new ResponseEntity<>(novaSaida, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<SaidaEntity> atualizarSaida(@PathVariable Integer id, @Valid @RequestBody SaidaEntity saida) {
        SaidaEntity SaidaAtualizada = saidaService.atualizarSaida(id, saida);
        return new ResponseEntity<>(saida, HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarSaida(@PathVariable Integer id) {
       saidaService.deletarSaidas(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
