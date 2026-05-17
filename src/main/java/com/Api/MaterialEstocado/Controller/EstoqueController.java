package com.Api.MaterialEstocado.Controller;

import com.Api.MaterialEstocado.Service.EstoqueService;

import java.util.Map;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estoque")
@RequiredArgsConstructor
public class EstoqueController {

    private final EstoqueService estoqueService;

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> consultar(
            @PathVariable Integer id) {

        Map<String, Object> estoque = estoqueService.consultarEstoque(id);

        return new ResponseEntity<>(estoque, HttpStatus.OK);
    }
}