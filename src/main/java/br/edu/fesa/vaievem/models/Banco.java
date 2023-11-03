
package br.edu.fesa.vaievem.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Banco implements Serializable {
    
    // Atributos
    private Long idBanco;
    private String descricao;

    // Atributos de relacionamento
    private List<ContaBancaria> contasBancarias;
    
    // Construtores
    public Banco() {
    }
    public Banco(Long idBanco) {
        this.idBanco = idBanco;
    }
    public Banco(String descricao) {
        this.descricao = descricao;
    }
    public Banco(Long idBanco, String descricao) {
        this.idBanco = idBanco;
        this.descricao = descricao;
    }

    // Getter e Setter
    public Long getIdBanco() {
        return idBanco;
    }
    public void setIdBanco(Long idBanco) {
        this.idBanco = idBanco;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<ContaBancaria> getContasBancarias() {
        if(contasBancarias == null){
            contasBancarias = new ArrayList();
        }
        return contasBancarias;
    }
    public void setContasBancarias(ArrayList<ContaBancaria> contasBancarias) {
        this.contasBancarias = contasBancarias;
    }
}
