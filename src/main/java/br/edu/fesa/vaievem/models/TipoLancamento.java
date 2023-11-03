
package br.edu.fesa.vaievem.models;

import java.io.Serializable;

public class TipoLancamento implements Serializable {
    
    private Long idTipoLancamento;
    private String descricao;

    public TipoLancamento() {
    }
    public TipoLancamento(Long idTipoLancamento) {
        this.idTipoLancamento = idTipoLancamento;
    }
    public TipoLancamento(String descricao) {
        this.descricao = descricao;
    }
    public TipoLancamento(Long idTipoLancamento, String descricao) {
        this.idTipoLancamento = idTipoLancamento;
        this.descricao = descricao;
    }

    public Long getIdTipoLancamento() {
        return idTipoLancamento;
    }
    public void setIdTipoLancamento(Long idTipoLancamento) {
        this.idTipoLancamento = idTipoLancamento;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
