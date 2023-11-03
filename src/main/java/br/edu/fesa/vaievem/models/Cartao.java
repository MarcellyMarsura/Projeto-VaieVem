
package br.edu.fesa.vaievem.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cartao implements Serializable {
    
    // Atributos
    private Long idCartao;
    private String descricao;
    private int diaFechamento;
    private int diaVencimento;
    private float limiteEstipulado; 

    // Atributos de relacionamento
    private ContaBancaria contaBancaria;
    private List<LancamentoCartao> lancamentosCartao;

    // Construtores
    public Cartao() {
    }
    public Cartao(Long idCartao) {
        this.idCartao = idCartao;
    }
    public Cartao(String descricao) {
        this.descricao = descricao;
    }
    public Cartao(Long idCartao, String descricao) {
        this.idCartao = idCartao;
        this.descricao = descricao;
    }
    public Cartao(Long idCartao, String descricao, float limiteEstipulado) {
        this.idCartao = idCartao;
        this.descricao = descricao;
        this.limiteEstipulado = limiteEstipulado;
    }
    public Cartao(Long idCartao, String descricao, int diaFechamento, int diaVencimento, float limiteEstipulado) {
        this.idCartao = idCartao;
        this.descricao = descricao;
        this.diaFechamento = diaFechamento;
        this.diaVencimento = diaVencimento;
        this.limiteEstipulado = limiteEstipulado;
    }

    // Getter e Setter
    public Long getIdCartao() {
        return idCartao;
    }
    public void setIdCartao(Long idCartao) {
        this.idCartao = idCartao;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getDiaFechamento() {
        return diaFechamento;
    }
    public void setDiaFechamento(int diaFechamento) {
        this.diaFechamento = diaFechamento;
    }

    public int getDiaVencimento() {
        return diaVencimento;
    }
    public void setDiaVencimento(int diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public float getLimiteEstipulado() {
        return limiteEstipulado;
    }
    public void setLimiteEstipulado(float limiteEstipulado) {
        this.limiteEstipulado = limiteEstipulado;
    }

    public ContaBancaria getContaBancaria() {
        return contaBancaria;
    }
    public void setContaBancaria(ContaBancaria contaBancaria) {
        this.contaBancaria = contaBancaria;
    }

    public List<LancamentoCartao> getLancamentosCartao() {
        if(lancamentosCartao == null){
            lancamentosCartao = new ArrayList();
        }
        return lancamentosCartao;
    }
    public void setLancamentosCartao(ArrayList<LancamentoCartao> lancamentosCartao) {
        this.lancamentosCartao = lancamentosCartao;
    }
}
