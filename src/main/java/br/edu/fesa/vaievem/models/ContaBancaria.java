
package br.edu.fesa.vaievem.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ContaBancaria implements Serializable {
    
    // Atributos
    private Long idContaBancaria;
    private String descricao;
    private String numeroAgencia;
    private String numeroConta;
    private float meta;
    
    // Atributos de relacionamento
    private Usuario usuario;
    private Banco banco;
    private List<Cartao> cartoes;
    private List<LancamentoConta> lancamentosConta;
    
    // Construtores
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
    
    public ContaBancaria(Long idContaBancaria, String descricao, float meta) {
        this.idContaBancaria = idContaBancaria;
        this.descricao = descricao;
        this.meta = meta;
    }

    public ContaBancaria(Long idContaBancaria, String descricao, String numeroAgencia, String numeroConta, float meta) {
        this.idContaBancaria = idContaBancaria;
        this.descricao = descricao;
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.meta = meta;
    }
    
    public ContaBancaria(Long idContaBancaria, Long idUsuario, Long idBanco, String descricao, String numeroAgencia, String numeroConta, float meta) {
        this.idContaBancaria = idContaBancaria;
        this.descricao = descricao;
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.meta = meta;
        
        this.usuario = new Usuario(idUsuario);
        this.banco = new Banco(idBanco);
    }

    // Getter e Setter
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
    
    public float getMeta() {
        return meta;
    }
    public void setMeta(float meta) {

        this.meta = meta;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Banco getBanco() {
        return banco;
    }
    public void setBanco(Banco banco) {
        this.banco = banco;
    }
    
    public List<Cartao> getCartoes() {
        if(cartoes == null){
            cartoes = new ArrayList();
        }
        return cartoes;
    }
    public void setCartoes(ArrayList<Cartao> cartoes) {
        this.cartoes = cartoes;
    }

    public List<LancamentoConta> getLancamentosConta() {
        if(lancamentosConta == null){
            lancamentosConta = new ArrayList();
        }
        return lancamentosConta;
    }
    public void setLancamentosConta(List<LancamentoConta> lancamentosConta) {
        this.lancamentosConta = lancamentosConta;
    }
    
    // Atributos Personalizados
    public float getSaldo(){
        float saldo = 0;
        
        for(LancamentoConta lancamento : lancamentosConta){
            saldo += lancamento.getValor();
        }
        
        return saldo;
    }
    
    @Override
    public String toString() {
        return descricao;
    }
}
