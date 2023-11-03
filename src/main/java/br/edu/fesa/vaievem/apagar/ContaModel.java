/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fesa.vaievem.apagar;

/**
 *
 * @author m.molinari.marsura
 */
public class ContaModel {
    private int Id;
    private String Descricao;
    private String Agencia;
    private String Conta;
    private String Banco;
    private Double Meta;

    public ContaModel(int Id, String Descricao, String Agencia, String Conta, String Banco, Double Meta) {
        this.Id = Id;
        this.Descricao = Descricao;
        this.Agencia = Agencia;
        this.Conta = Conta;
        this.Banco = Banco;
        this.Meta = Meta;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getAgencia() {
        return Agencia;
    }

    public void setAgencia(String Agencia) {
        this.Agencia = Agencia;
    }

    public String getConta() {
        return Conta;
    }

    public void setConta(String Conta) {
        this.Conta = Conta;
    }

    public String getBanco() {
        return Banco;
    }

    public void setBanco(String Banco) {
        this.Banco = Banco;
    }

    public Double getMeta() {
        return Meta;
    }

    public void setMeta(Double Meta) {
        this.Meta = Meta;
    }
    
}
