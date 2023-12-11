/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fesa.vaievem.viewmodels;

import br.edu.fesa.vaievem.models.Banco;
import br.edu.fesa.vaievem.models.ContaBancaria;
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
    
    private Banco bancoModel;

    public ContaViewModel(ContaBancaria model){
        this.Id = new SimpleStringProperty(String.valueOf(model.getIdContaBancaria()));
        this.Descricao = new SimpleStringProperty(model.getDescricao());
        this.Agencia = new SimpleStringProperty(model.getNumeroAgencia());
        this.Conta = new SimpleStringProperty(model.getNumeroConta());
        this.Banco = new SimpleStringProperty(model.getBanco().getDescricao());
        this.Meta = new SimpleStringProperty(String.valueOf(model.getMeta()));
        this.bancoModel = model.getBanco();
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

    public Banco getBancoModel() {
        return bancoModel;
    }

    public void setBancoModel(Banco bancoModel) {
        this.bancoModel = bancoModel;
    }
}

