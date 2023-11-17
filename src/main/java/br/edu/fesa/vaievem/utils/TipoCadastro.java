
package br.edu.fesa.vaievem.utils;

public enum TipoCadastro {
    
    INSERT(0),
    UPDATE(1);

    private int tipo;
    
    TipoCadastro (int tipo) {
    this.tipo = tipo;
}
    public int getTipo() {
        return tipo;
    }
    
}
