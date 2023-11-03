
package br.edu.fesa.vaievem.models;

import java.io.Serializable;
import java.util.Date;

public class LancamentoCartao implements Serializable {
    
    // Atributos
    private Long idLancamentoCartao;
    private Date dataLancamento;
    private float valor;
    private String comentario;

    // Atributos de relacionamento
    private Cartao cartao;
    
    // Construtores
    public LancamentoCartao() {
    }
    public LancamentoCartao(Long idLancamentoCartao) {
        this.idLancamentoCartao = idLancamentoCartao;
    }
    public LancamentoCartao(Long idLancamentoCartao, Date dataLancamento, float valor) {
        this.idLancamentoCartao = idLancamentoCartao;
        this.dataLancamento = dataLancamento;
        this.valor = valor;
    }
    public LancamentoCartao(Long idLancamentoCartao, Date dataLancamento, float valor, String comentario) {
        this.idLancamentoCartao = idLancamentoCartao;
        this.dataLancamento = dataLancamento;
        this.valor = valor;
        this.comentario = comentario;
    }

    // Getter e Setter
    public Long getIdLancamentoCartao() {
        return idLancamentoCartao;
    }
    public void setIdLancamentoCartao(Long idLancamentoCartao) {
        this.idLancamentoCartao = idLancamentoCartao;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }
    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Cartao getCartao() {
        return cartao;
    }
    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }
}
