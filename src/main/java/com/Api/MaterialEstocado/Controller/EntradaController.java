package com.Api.MaterialEstocado.Controller;

import com.Api.MaterialEstocado.Data.EntradaEntity;
import com.Api.MaterialEstocado.Service.EntradaService;

import jakarta.validation.Valid;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entrada")
public class EntradaController {

    @Autowired
    private EntradaService entradaService;

    @GetMapping("/listar")
    public ResponseEntity<List<EntradaEntity>> getAllEntrada() {
        List<EntradaEntity> entradas = entradaService.listarTodasEntradas();
        return new ResponseEntity<>(entradas, HttpStatus.OK);
    }

    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<EntradaEntity> getEntradaById(@PathVariable Integer id) {
        EntradaEntity entrada = entradaService.getEntradaId(id);
        return new ResponseEntity<>(entrada, HttpStatus.OK);
    }

    @PostMapping("/adicionar")
    public ResponseEntity<EntradaEntity> addEntrada(
            @Valid @RequestBody EntradaEntity entrada) {

        EntradaEntity novaEntrada = entradaService.cadastrarEntrada(entrada);
        return new ResponseEntity<>(novaEntrada, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<EntradaEntity> atualizarEntrada(
            @PathVariable Integer id,
            @Valid @RequestBody EntradaEntity entrada) {

        EntradaEntity entradaAtualizada =
                entradaService.atualizarEntrada(id, entrada);

        return new ResponseEntity<>(entradaAtualizada, HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarEntrada(@PathVariable Integer id) {
        entradaService.deletarEntrada(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
