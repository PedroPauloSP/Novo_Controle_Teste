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

    @Min(value = 1, message = "Quantidade deve ser maior que zero")
    @Column(nullable = false)
    private Integer quantidade;
    
    @Column(nullable = false)
private LocalDate data;

    public EntradaEntity(Integer id, EquipamentoEntity equipamento, Integer quantidade, LocalDate data) {
        this.id = id;
        this.equipamento = equipamento;
        this.quantidade = quantidade;
        this.data = data;
    }

   

    public EntradaEntity() {
    }
}





/*package com.Api.MaterialEstocado.Data;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
@Entity
@Table(name = "entrada")
public class EntradaEntity {
    
    public EntradaEntity(Integer id, EquipamentoEntity equipamento, Integer quantidade) {
        this.id = id;
        this.equipamento = equipamento;
        this.quantidade = quantidade;
    }

    public EntradaEntity() {
    }
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "equipamento_id")
    private EquipamentoEntity equipamento;

    @Min(value = 1, message = "Quantidade deve ser maior que zero")
    private Integer quantidade;
}

*/
/*package com.Api.MaterialEstocado.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;

@Data 
@Entity 
@Table(name="entrada") 
public class EntradaEntity {
     @Id 
@GeneratedValue(strategy = GenerationType.AUTO) 
 
    private Integer id;
   
    private EquipamentoEntity equipamento_id;
    
    private int quantidade; 
   /*
    @CNPJ(message="CNPJ invalido")
    private String cnpj;
    
    @Size(min=2, message = "Informe ao menos 2 caracteres para o campo nome")
    private String razaoSocial;
   
   @NotBlank(message="Telefone obrigatório")
    private String telefone;
   
   @Email(message="E-mail inválido")
    private String email;
   
    
}
*/