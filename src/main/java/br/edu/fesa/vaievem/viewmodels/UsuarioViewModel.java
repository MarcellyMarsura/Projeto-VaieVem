/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fesa.vaievem.viewmodels;

import br.edu.fesa.vaievem.models.Usuario;
import javafx.beans.property.SimpleStringProperty;

public class UsuarioViewModel {

    private SimpleStringProperty Id;
    private SimpleStringProperty Nome;
    private SimpleStringProperty Email;

    public UsuarioViewModel(Usuario usuarioModel){
        this.Id = new SimpleStringProperty(String.valueOf(usuarioModel.getIdUsuario()));
        this.Nome = new SimpleStringProperty(usuarioModel.getNome());
        this.Email = new SimpleStringProperty(usuarioModel.getEmail());
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

