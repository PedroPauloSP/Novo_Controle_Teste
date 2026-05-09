package com.Api.MaterialEstocado.Controller;

import com.Api.MaterialEstocado.Data.CategoriaEntity;
import com.Api.MaterialEstocado.Service.CategoriaService;
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
@RequestMapping("/categoria")

public class CategoriaController {
     @Autowired
   
    CategoriaService categoriaservice;
     
     @GetMapping("/cadastrar")

    public ResponseEntity<CategoriaEntity> CadCategoria(@RequestBody CategoriaEntity cat) {

        CategoriaEntity novaCategoria = categoriaservice.cadastrarcategoria(cat);

        return new ResponseEntity<>(novaCategoria, HttpStatus.CREATED);
    }

    

    @GetMapping("/listar")

    public ResponseEntity<List> getAllCategoria() {
        List<CategoriaEntity> categorias = categoriaservice.listarTodasCategorias();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

    @GetMapping("/pesquisar/{id}")

    public ResponseEntity<CategoriaEntity> getCategoriaById(@Valid @PathVariable Integer id) {

        CategoriaEntity categoria = categoriaservice.getCategoriaId(id);

        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }

    @PostMapping("/adicionar")

    public ResponseEntity<CategoriaEntity> addCategoria(@RequestBody CategoriaEntity cat) {

        CategoriaEntity novaCategoria = categoriaservice.cadastrarcategoria(cat);

        return new ResponseEntity<>(novaCategoria, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar/{id}")

    public ResponseEntity<CategoriaEntity> atualizarCategoria(@PathVariable Integer id, @RequestBody CategoriaEntity categoria) {
        CategoriaEntity categoriaAtualizada = categoriaservice.atualizarCategoria(id, categoria);

        return new ResponseEntity<>(categoriaAtualizada, HttpStatus.OK);

    }

    @DeleteMapping("/deletar/{id}")

    public ResponseEntity deletarCategoria(@PathVariable Integer id) {

        categoriaservice.deletarCategoria(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
