
package br.edu.fesa.vaievem.models;

import java.io.Serializable;

public class Usuario implements Serializable {
    
    private Long idUsuario;
    private String nome;
    private String email;
    private String senha;
    private boolean ativo;
    private boolean administrador;
    
    public Usuario(){
    }
    public Usuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    public Usuario(String email) {
        this.email = email;
    }
    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }
    public Usuario(Long idUsuario, String nome, String email, String senha) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.ativo = true;
        this.administrador = false;
    }
    public Usuario(Long idUsuario, String nome, String email, String senha, boolean ativo) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.ativo = ativo;
        this.administrador = false;
    }
    public Usuario(Long idUsuario, String nome, String email, String senha, boolean ativo, boolean administrador) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.ativo = ativo;
        this.administrador = administrador;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean isAdministrador() {
        return administrador;
    }
    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }
}
