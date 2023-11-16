package br.edu.fesa.vaievem.models;

import java.io.Serializable;
import java.util.Date;

public class LancamentoConta implements Serializable {
    
    // Atributos
    private Long idLancamentoConta;
    private Date dataLancamento;
    private float valor;
    private String comentario;

    // Atributos de relacionamento
    private TipoLancamento tipoLancamento;
    private ContaBancaria contaBancaria;
    
    // Construtores
    public LancamentoConta() {
    }
    public LancamentoConta(Long idLancamentoConta) {
        this.idLancamentoConta = idLancamentoConta;
    }
    public LancamentoConta(Long idLancamentoConta, Date dataLancamento, float valor) {
        this.idLancamentoConta = idLancamentoConta;
        this.dataLancamento = dataLancamento;
        this.valor = valor;
    }
    public LancamentoConta(Long idLancamentoConta, Date dataLancamento, float valor, String comentario) {
        this.idLancamentoConta = idLancamentoConta;
        this.dataLancamento = dataLancamento;
        this.valor = valor;
        this.comentario = comentario;
    }
    
    public LancamentoConta(Long idLancamentoConta, Long tipo, Long idContaBancaria, Date dataLancamento, float valor, String comentario) {
        this.idLancamentoConta = idLancamentoConta;
        this.dataLancamento = dataLancamento;
        this.valor = valor;
        this.comentario = comentario;
        
        this.tipoLancamento = new TipoLancamento(tipo);
        this.contaBancaria = new ContaBancaria(idContaBancaria);
    }

    // Getter e Setter
    public Long getIdLancamentoConta() {
        return idLancamentoConta;
    }
    public void setIdLancamentoConta(Long idLancamentoConta) {
        this.idLancamentoConta = idLancamentoConta;
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

    public TipoLancamento getTipoLancamento() {
        return tipoLancamento;
    }
    public void setTipoLancamento(TipoLancamento tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }

    public ContaBancaria getContaBancaria() {
        return contaBancaria;
    }
    public void setContaBancaria(ContaBancaria contaBancaria) {
        this.contaBancaria = contaBancaria;
    }
}
