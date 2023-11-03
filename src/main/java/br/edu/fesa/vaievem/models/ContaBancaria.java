
package br.edu.fesa.vaievem.models;

import java.io.Serializable;

public class ContaBancaria implements Serializable {
    
    private Long idContaBancaria;
    private String descricao;
    private String numeroAgencia;
    private String numeroConta;
    private Long meta;

    public ContaBancaria() {
    }
    public ContaBancaria(Long idContaBancaria) {
        this.idContaBancaria = idContaBancaria;
    }
    public ContaBancaria(String descricao) {
        this.descricao = descricao;
    }
    public ContaBancaria(Long idContaBancaria, String descricao) {
        this.idContaBancaria = idContaBancaria;
        this.descricao = descricao;
    }
    public ContaBancaria(Long idContaBancaria, String descricao, Long meta) {
        this.idContaBancaria = idContaBancaria;
        this.descricao = descricao;
        this.meta = meta;
    }
    public ContaBancaria(Long idContaBancaria, String descricao, String numeroAgencia, String numeroConta, Long meta) {
        this.idContaBancaria = idContaBancaria;
        this.descricao = descricao;
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.meta = meta;
    }

    public Long getIdContaBancaria() {
        return idContaBancaria;
    }
    public void setIdContaBancaria(Long idContaBancaria) {
        this.idContaBancaria = idContaBancaria;
    }
    
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getNumeroAgencia() {
        return numeroAgencia;
    }
    public void setNumeroAgencia(String numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }
    
    public String getNumeroConta() {
        return numeroConta;
    }
    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }
    
    public Long getMeta() {
        return meta;
    }
    public void setMeta(Long meta) {
        this.meta = meta;
    }
}
