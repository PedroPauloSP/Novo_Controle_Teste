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
   


/*
package com.Api.MaterialEstocado.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data 
@Entity 
@Table(name="saida") 
public class SaidaEntity {
     @Id 
@GeneratedValue(strategy = GenerationType.AUTO) 
 
    private Integer id;
   
    @CPF(message="CNPJ invalido")
    private String cnpj;
    
    @Size(min=2, message = "Informe ao menos 2 caracteres para o campo nome")
    private String razaoSocial;
   
   @NotBlank(message="Telefone obrigatório")
    private String telefone;
   
   @Email(message="E-mail inválido")
    private String email;

}
*/