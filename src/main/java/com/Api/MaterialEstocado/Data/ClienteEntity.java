
package com.Api.MaterialEstocado.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Entity
@Table (name="cliente")
public class ClienteEntity {
   
   @Id 
@GeneratedValue(strategy = GenerationType.AUTO) 
 
    private Integer id;
   
   //  @Size(min=2, message = "Informe ao menos 2 caracteres para o campo nome")
    private String razaosocial;
 
     //@CNPJ(message="cnpj invalido")
    private String cnpj;
   
   //@Email(message="Endereço inválido")
    private String endereco;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEnderco() {
        return endereco;
    }

    public void setEnderco(String enderco) {
        this.endereco = enderco;
    }
   
    
    
}

