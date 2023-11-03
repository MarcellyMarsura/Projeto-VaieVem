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
public class CartaoViewModel {
    private SimpleStringProperty Id;
    private SimpleStringProperty Descricao;
    private SimpleStringProperty DiaFechamento;
    private SimpleStringProperty Conta;
    private SimpleStringProperty DiaVencimento;
    private SimpleStringProperty Limite;

    public CartaoViewModel(String id, String descricao, String diaFechamento, String conta, String diaVencimento, String limite){
        this.Id = new SimpleStringProperty(id);
        this.Descricao = new SimpleStringProperty(descricao);
        this.DiaFechamento = new SimpleStringProperty(diaFechamento);
        this.Conta = new SimpleStringProperty(conta);
        this.DiaVencimento = new SimpleStringProperty(diaVencimento);
        this.Limite = new SimpleStringProperty(limite);
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

    public String getDiaFechamento() {
        return this.DiaFechamento.get();
    }


    public void setDiaFechamento(String diaFechamento) {
        this.DiaFechamento.set(diaFechamento);
    }

  
    public String getConta() {
        return this.Conta.get();
    }

    public void setConta(String conta) {
        this.Conta.set(conta);
    }


    public String getDiaVencimento() {
        return this.DiaVencimento.get();
    }


    public void setDiaVencimento(String diaVencimento) {
        this.DiaVencimento.set(diaVencimento);
    }
    
    public String getLimite() {
        return this.Limite.get();
    }


    public void setLimite(String limite) {
        this.Limite.set(limite);
    }
}
