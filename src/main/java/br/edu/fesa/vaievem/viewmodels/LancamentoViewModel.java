/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fesa.vaievem.viewmodels;

import br.edu.fesa.vaievem.models.LancamentoConta;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author m.molinari.marsura
 */
public class LancamentoViewModel {
    private SimpleStringProperty Id;
    private SimpleStringProperty Tipo;
    private SimpleStringProperty Data;
    private SimpleStringProperty Valor;
    private SimpleStringProperty Comentario;

    public LancamentoViewModel(String id, String tipo, String data, String valor, String comentario){
        this.Id = new SimpleStringProperty(id);
        this.Tipo = new SimpleStringProperty(tipo);
        this.Data = new SimpleStringProperty(data);
        this.Valor = new SimpleStringProperty(valor);
        this.Comentario = new SimpleStringProperty(comentario);
    }

    public LancamentoViewModel(LancamentoConta lancamento){
        
        this.Id = new SimpleStringProperty(String.valueOf(lancamento.getIdLancamentoConta()));
        this.Tipo = new SimpleStringProperty(lancamento.getTipoLancamento().getDescricao());
        this.Data = new SimpleStringProperty(String.valueOf(lancamento.getDataLancamento()));
        this.Valor = new SimpleStringProperty(String.valueOf(lancamento.getValor()));
        this.Comentario = new SimpleStringProperty(lancamento.getComentario());
    }
    
    public String getId() {
        return this.Id.get();
    }

    public void setId(String id) {
        this.Id.set(id);
    }

    public String getTipo() {
        return this.Tipo.get();
    }


    public void setTipo(String tipo) {
        this.Tipo.set(tipo);
    }

    public String getData() {
        return this.Data.get();
    }


    public void setData(String data) {
        this.Data.set(data);
    }

  
    public String getValor() {
        return this.Valor.get();
    }

    public void setValor(String valor) {
        this.Valor.set(valor);
    }


    public String getComentario() {
        return this.Comentario.get();
    }


    public void setComentario(String comentario) {
        this.Comentario.set(comentario);
    }
    
    
}