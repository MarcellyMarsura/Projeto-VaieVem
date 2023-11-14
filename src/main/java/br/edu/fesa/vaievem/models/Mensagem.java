
package br.edu.fesa.vaievem.models;


public class Mensagem {
    
    private String titulo;
    private String corpo;

    public Mensagem(String titulo, String corpo) {
        this.titulo = titulo;
        this.corpo = corpo;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCorpo() {
        return corpo;
    }
    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }
}
