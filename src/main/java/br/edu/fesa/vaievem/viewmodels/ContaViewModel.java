/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fesa.vaievem.viewmodels;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author m.molinari.marsura
 */
public class ContaViewModel {
    private SimpleStringProperty Id;
    private SimpleStringProperty Descricao;
    private SimpleStringProperty Agencia;
    private SimpleStringProperty Conta;
    private SimpleStringProperty Banco;
    private SimpleStringProperty Meta;

    public ContaViewModel(String id, String descricao, String agencia, String conta, String banco, String meta){
        this.Id = new SimpleStringProperty(id);
        this.Descricao = new SimpleStringProperty(descricao);
        this.Agencia = new SimpleStringProperty(agencia);
        this.Conta = new SimpleStringProperty(conta);
        this.Banco = new SimpleStringProperty(banco);
        this.Meta = new SimpleStringProperty(meta);
    }

    public String getId() {
        return this.Id.get();
    }

    public void setId(String id) {
        this.Id.set(id);
    }

    public String getDescricao() {
        return this.Descricao.get();
    }


    public void setDescricao(String descricao) {
        this.Descricao.set(descricao);
    }

    public String getAgencia() {
        return this.Agencia.get();
    }


    public void setAgencia(String agencia) {
        this.Agencia.set(agencia);
    }

  
    public String getConta() {
        return this.Conta.get();
    }

    public void setConta(String conta) {
        this.Conta.set(conta);
    }


    public String getBanco() {
        return this.Banco.get();
    }


    public void setBanco(String banco) {
        this.Banco.set(banco);
    }
    
    public String getMeta() {
        return this.Meta.get();
    }


    public void setMeta(String meta) {
        this.Meta.set(meta);
    }
}