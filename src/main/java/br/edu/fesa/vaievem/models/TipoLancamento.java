
package br.edu.fesa.vaievem.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TipoLancamento implements Serializable {
    
    // Atributos
    private Long idTipoLancamento;
    private String descricao;

    // Atributos de relacionamento
    private List<LancamentoConta> lancamentosConta;
    
    // Construtores
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

    // Getter e Setter
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

    public List<LancamentoConta> getLancamentosConta() {
        if(lancamentosConta == null){
            lancamentosConta = new ArrayList();
        }
        return lancamentosConta;
    }
    public void setLancamentosConta(ArrayList<LancamentoConta> lancamentosConta) {
        this.lancamentosConta = lancamentosConta;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
