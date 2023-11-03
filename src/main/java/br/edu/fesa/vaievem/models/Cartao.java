
package br.edu.fesa.vaievem.models;

import java.io.Serializable;

public class Cartao implements Serializable {
    
    private Long idCartao;
    private String descricao;
    private int diaFechamento;
    private int diaVencimento;
    private float limiteEstipulado; 

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
}
