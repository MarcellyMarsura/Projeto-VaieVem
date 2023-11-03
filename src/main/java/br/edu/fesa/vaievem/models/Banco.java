
package br.edu.fesa.vaievem.models;

import java.io.Serializable;


public class Banco implements Serializable {
    
    private Long idBanco;
    private String descricao;

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
}
