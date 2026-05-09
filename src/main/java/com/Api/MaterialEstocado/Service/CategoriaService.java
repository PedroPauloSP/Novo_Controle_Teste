/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Api.MaterialEstocado.Service;

import com.Api.MaterialEstocado.Data.CategoriaEntity;
import com.Api.MaterialEstocado.Data.CategoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pedro
 */

 @Service
public class CategoriaService {
     @Autowired
  CategoriaRepository categoriaRepository;
  
  public CategoriaEntity cadastrarcategoria (CategoriaEntity cat){
      cat.setId(null);
      
      categoriaRepository.save(cat);
      return cat;
  }
   public CategoriaEntity getCategoriaId(Integer CatId) { 

 return categoriaRepository.findById(CatId).orElse(null);
 
   }
  public List<CategoriaEntity> listarTodasCategorias(){
      return categoriaRepository.findAll();
  }
  public void deletarCategoria(Integer catId) { 
CategoriaEntity Cat = getCategoriaId(catId); 

categoriaRepository.deleteById(Cat.getId()); 

  }
  public CategoriaEntity atualizarCategoria(Integer catId, CategoriaEntity categoriaRequest) {

        CategoriaEntity cat = getCategoriaId(catId);

        cat.setNomecategoria(categoriaRequest.getNomecategoria());

        categoriaRepository.save(cat);

        return cat;

  }
   public String CadastrarCategoria(){
        return "categoria";
    }
 
  
}

