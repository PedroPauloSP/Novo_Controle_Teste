package TesteUnitario;

import com.Api.MaterialEstocado.Service.EstoqueService;
import com.Api.MaterialEstocado.Data.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TesteUnitario{

    @Mock
    private EntradaRepository entradaRepository;

    @Mock
    private SaidaRepository saidaRepository;

    @Mock
    private EquipamentoRepository equipamentoRepository;

    @InjectMocks
    private EstoqueService estoqueService;

    @Test
    void deveCalcularEstoqueComSucesso() {

        Integer id = 1;

        EquipamentoEntity equipamento = new EquipamentoEntity();
        equipamento.setId(id);
        equipamento.setNome("Notebook");

        when(equipamentoRepository.findById(id))
                .thenReturn(Optional.of(equipamento));

        when(entradaRepository.totalEntradas(id)).thenReturn(100);
        when(saidaRepository.totalSaidas(id)).thenReturn(40);

        Map<String, Object> resultado = estoqueService.consultarEstoque(id);

        assertEquals(1, resultado.get("id"));
        assertEquals("Notebook", resultado.get("nome"));
        assertEquals(60, resultado.get("estoque"));
    }

    @Test
    void deveRetornarZeroQuandoValoresForemNull() {

        Integer id = 2;

        EquipamentoEntity equipamento = new EquipamentoEntity();
        equipamento.setId(id);
        equipamento.setNome("Mouse");

        when(equipamentoRepository.findById(id))
                .thenReturn(Optional.of(equipamento));

        when(entradaRepository.totalEntradas(id)).thenReturn(null);
        when(saidaRepository.totalSaidas(id)).thenReturn(null);

        Map<String, Object> resultado = estoqueService.consultarEstoque(id);

        assertEquals(0, resultado.get("estoque"));
    }

    @Test
    void deveLancarExcecaoQuandoEquipamentoNaoExistir() {

        Integer id = 99;

        when(equipamentoRepository.findById(id))
                .thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(
                RuntimeException.class,
                () -> estoqueService.consultarEstoque(id)
        );

        assertEquals("Equipamento não encontrado", ex.getMessage());
    }
}
