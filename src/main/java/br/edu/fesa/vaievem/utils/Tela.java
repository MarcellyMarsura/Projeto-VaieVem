/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fesa.vaievem.utils;

/**
 *
 * @author m.molinari.marsura
 */
public enum Tela {
    
    SOBRE("Sobre"),
    PERFIL("Perfil"),
    LOGIN("Login"),
    HOME("Home"),
    DETALHE_CONTA("DetalheConta"),
    CONTAS("Contas"),
    CARTOES("Cartoes"),
    CADASTRO_USUARIO("CadastroUsuario"),
    CADASTRO_LANCAMENTO_CONTA("CadastroLancamentoConta"),
    CADASTRO_LANCAMENTO_CARTAO("CadastroLancamentoCartao"),
    CADASTRO_CONTA("CadastroConta"),
    CADASTRO_CARTAO("CadastroCartao"),
    ADMINISTRADOR("Administrador"),
    
    MENU("Menu");
    
    private String nome;
    
    Tela (String nome) {
    this.nome = nome;
}
    public String getNome() {
        return nome;
    }
}
