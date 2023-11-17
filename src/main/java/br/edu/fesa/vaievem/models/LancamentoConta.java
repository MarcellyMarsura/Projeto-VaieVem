package br.edu.fesa.vaievem.models;

import java.io.Serializable;
import java.time.LocalDate;

public class LancamentoConta implements Serializable {
    
    // Atributos
    private Long idLancamentoConta;
    private LocalDate dataLancamento;
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
    public LancamentoConta(Long idLancamentoConta, LocalDate dataLancamento, float valor) {
        this.idLancamentoConta = idLancamentoConta;
        this.dataLancamento = dataLancamento;
        this.valor = valor;
    }
    public LancamentoConta(Long idLancamentoConta, LocalDate dataLancamento, float valor, String comentario) {
        this.idLancamentoConta = idLancamentoConta;
        this.dataLancamento = dataLancamento;
        this.valor = valor;
        this.comentario = comentario;
    }

    // Getter e Setter
    public Long getIdLancamentoConta() {
        return idLancamentoConta;
    }
    public void setIdLancamentoConta(Long idLancamentoConta) {
        this.idLancamentoConta = idLancamentoConta;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }
    public void setDataLancamento(LocalDate dataLancamento) {
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
