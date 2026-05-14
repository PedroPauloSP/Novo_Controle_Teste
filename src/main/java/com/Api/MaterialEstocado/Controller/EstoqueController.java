package com.Api.MaterialEstocado.Controller;

import com.Api.MaterialEstocado.Service.EstoqueService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EstoqueController {

    private final EstoqueService estoqueService;

    @GetMapping("/estoque/{equipamentoId}")
    public Map<String, Object> estoque(
            @PathVariable Integer equipamentoId) {

        return estoqueService.consultarEstoque(equipamentoId);
    }
}
   
    
   /* @GetMapping("/{equipamentoId}")
    public ResponseEntity<Integer> consultarEstoque(
            @PathVariable Integer equipamentoId){

        Integer estoque =
                estoqueService.calcularEstoque(equipamentoId);

        return ResponseEntity.ok(estoque);
    }
}*/
