package com.Api.MaterialEstocado.Data;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
@Table(name = "entrada")
public class EntradaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "equipamento_id", nullable = false)
    private EquipamentoEntity equipamento;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id", nullable = false)
    private FornecedorEntity fornecedor;

    @Min(value = 1, message = "Quantidade deve ser maior que zero")
    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private LocalDate data;

    public EntradaEntity() {
    }

    public EntradaEntity(
            Integer id,
            EquipamentoEntity equipamento,
            FornecedorEntity fornecedor,
            Integer quantidade,
            LocalDate data) {

        this.id = id;
        this.equipamento = equipamento;
        this.fornecedor = fornecedor;
        this.quantidade = quantidade;
        this.data = data;
    }
}

