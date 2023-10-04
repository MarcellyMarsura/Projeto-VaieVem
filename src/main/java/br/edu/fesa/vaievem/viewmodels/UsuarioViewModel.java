/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fesa.vaievem.viewmodels;

import javafx.beans.property.SimpleStringProperty;

public class UsuarioViewModel {

    private SimpleStringProperty Id;
    private SimpleStringProperty Nome;
    private SimpleStringProperty Email;

    public UsuarioViewModel(String id, String nome, String email){
        this.Id = new SimpleStringProperty(id);
        this.Nome = new SimpleStringProperty(nome);
        this.Email = new SimpleStringProperty(email);
    }
    
    public String getId() {
        return Id.get();
    }

    public void setId(String id) {
        this.Id.set(id);
    }

    public String getNome() {
        return Nome.get();
    }

    public void setNome(String nome) {
        this.Nome.set(nome);
    }

    public String getEmail() {
        return Email.get();
    }

    public void setEmail(String email) {
        this.Email.set(email);
    }
        
}
