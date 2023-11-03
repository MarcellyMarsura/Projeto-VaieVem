
package br.edu.fesa.vaievem.main;

import br.edu.fesa.vaievem.dao.BancoDAO;
import br.edu.fesa.vaievem.models.Banco;

public class Main {
    
    public static void main(String[] args) {
        
        BancoDAO dao = new BancoDAO();
        
        try{
            var listagem = dao.listar();   
            
            for(Banco l : listagem){
                System.out.println("Id: " + l.getIdBanco() + " - Descrição: " + l.getDescricao());
            }
            
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
