package com.Api.MaterialEstocado.Data;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
@Table(name = "saida")
public class SaidaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "equipamento_id", nullable = false)
    private EquipamentoEntity equipamento;

    @Min(value = 1, message = "Quantidade deve ser maior que zero")
    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private LocalDate data;

    public SaidaEntity() {
    }

    public SaidaEntity(Integer id, EquipamentoEntity equipamento, Integer quantidade, LocalDate data) {
        this.id = id;
        this.equipamento = equipamento;
        this.quantidade = quantidade;
        this.data = data;
    }
}
