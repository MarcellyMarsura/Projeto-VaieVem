
package br.edu.fesa.vaievem.main;

import br.edu.fesa.vaievem.dao.BancoDAO;
import br.edu.fesa.vaievem.dao.CartaoDAO;
import br.edu.fesa.vaievem.dao.ContaBancariaDAO;
import br.edu.fesa.vaievem.dao.LancamentoCartaoDAO;
import br.edu.fesa.vaievem.dao.LancamentoContaDAO;
import br.edu.fesa.vaievem.dao.TipoLancamentoDAO;
import br.edu.fesa.vaievem.dao.UsuarioDAO;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.Banco;
import br.edu.fesa.vaievem.models.Cartao;
import br.edu.fesa.vaievem.models.ContaBancaria;
import br.edu.fesa.vaievem.models.LancamentoCartao;
import br.edu.fesa.vaievem.models.LancamentoConta;
import br.edu.fesa.vaievem.models.TipoLancamento;
import br.edu.fesa.vaievem.models.Usuario;
import java.time.LocalDate;
import java.time.Month;

public class Main {
    
    public static void main(String[] args) {
        
        BancoDAO daoBanco = new BancoDAO();
        CartaoDAO daoCartao = new CartaoDAO();
        ContaBancariaDAO daoContaBancaria = new ContaBancariaDAO();
        UsuarioDAO daoUsuario = new UsuarioDAO(); 
        LancamentoCartaoDAO daoLancamentoCartao = new LancamentoCartaoDAO();
        LancamentoContaDAO daoLancamentoConta = new LancamentoContaDAO();
        TipoLancamentoDAO daoTipoLancamento = new TipoLancamentoDAO();
        
        try{ 
        
           //TesteBanco(daoBanco); 
           //TesteCartao(daoCartao);
           //TesteUsuario(daoUsuario);
           //TesteConta(daoContaBancaria);
           //TesteLancamentoCartao(daoLancamentoCartao);
           TesteLancamentoConta(daoLancamentoConta);
           //TesteTipoLancamento(daoTipoLancamento);

            
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void TesteBanco(BancoDAO daoBanco) throws PersistenciaException{
        long idBanco = 1;   
        String descricaoBanco = "Itau";          
        Banco banco = new Banco(idBanco, descricaoBanco);
        
        //daoBanco.inserir(banco);           
        //daoBanco.alterar(banco);
        //daoBanco.remover(id);
        
        var listagemBanco = daoBanco.listar();
        var listagemBancoPorId = daoBanco.listarPorId(idBanco);
        
        System.out.println("LISTAGEM DE BANCOS - GERAL");
        for(Banco l : listagemBanco){
            System.out.println("idBanco: " + l.getIdBanco()+ " / descricao: " + l.getDescricao());
        }
        System.out.println();
        
        System.out.println("LISTAGEM DE BANCOS - POR ID");
        if(listagemBancoPorId != null){
            System.out.println("idBanco: " + listagemBancoPorId.getIdBanco()+ " / descricao: " + listagemBancoPorId.getDescricao());
        }
        System.out.println();
    }
    
    public static void TesteCartao(CartaoDAO dao) throws PersistenciaException{
        long id =  4;
        long idConta = 11;
        long idUsuario = 2;
        String descricaoCartao = "DEBITO2";
        int diaFechamento = 20;
        int diaVencimento = 5;
        float limiteEstipulado = 700;
        
        Cartao objeto = new Cartao(id, idConta, descricaoCartao, diaFechamento, diaVencimento, limiteEstipulado);
        
        //dao.inserir(objeto);
        //dao.alterar(objeto);
        //dao.remover(id);
        
        var listagemCartao = dao.listar();
        var listagemCartaoPorId = dao.listarPorId(id);
        var listagemCartaoPorConta = dao.listarPorConta(idConta);
        var listagemCartaoPorUsuario = dao.listarPorUsuario(idUsuario, null);
            
        System.out.println("LISTAGEM DE CARTOES - GERAL");
        for(Cartao l : listagemCartao){
            System.out.println("idCartao: " + l.getIdCartao()+ " / descricao: " + l.getDescricao() 
                    + " / diaFechamento: " + l.getDiaFechamento() + " / diaVencimento: " + l.getDiaVencimento() 
                    + "/ limiteEstipulado: " + l.getLimiteEstipulado());
        }
        System.out.println();
        
        System.out.println("LISTAGEM DE CARTOES - POR ID");
        if(listagemCartaoPorId != null){
            System.out.println("idCartao: " + listagemCartaoPorId.getIdCartao()+ " / descricao: " + listagemCartaoPorId.getDescricao() 
                    + " / diaFechamento: " + listagemCartaoPorId.getDiaFechamento() + " / diaVencimento: " + listagemCartaoPorId.getDiaVencimento() 
                    + "/ limiteEstipulado: " + listagemCartaoPorId.getLimiteEstipulado());
        }
        System.out.println();
        
        System.out.println("LISTAGEM DE CARTOES - POR CONTA");
        for(Cartao l : listagemCartaoPorConta){
            System.out.println("idCartao: " + l.getIdCartao()+ " / descricao: " + l.getDescricao() 
                    + " / diaFechamento: " + l.getDiaFechamento() + " / diaVencimento: " + l.getDiaVencimento() 
                    + "/ limiteEstipulado: " + l.getLimiteEstipulado());
        }
        System.out.println();
        
        System.out.println("LISTAGEM DE CARTOES - POR USUARIO");
        for(Cartao l : listagemCartaoPorUsuario){
            System.out.println("idCartao: " + l.getIdCartao()+ " / descricao: " + l.getDescricao() 
                    + " / diaFechamento: " + l.getDiaFechamento() + " / diaVencimento: " + l.getDiaVencimento() 
                    + "/ limiteEstipulado: " + l.getLimiteEstipulado());
        }
        System.out.println();
    }
    
    public static void TesteUsuario(UsuarioDAO dao) throws PersistenciaException{
        
        long id = 2;
        String nome = "Analuz";
        String email = "teste@gmail.com";
        String senha = "123";
        Boolean ativo = true;
        Boolean adm = true;
        
        Usuario objeto = new Usuario(id, nome,email, senha, ativo, adm);
        
        //dao.inserir(objeto);
        //dao.alterar(objeto);
        //dao.remover(id);
        
        var listagem = dao.listar();
        var listagemPorId = dao.listarPorId(id);       
        var listagemPorEmail = dao.listarPorEmail(email);

            
        System.out.println("LISTAGEM DE USUARIOS - GERAL");
        for(Usuario l : listagem){
            System.out.println("idUsuario: " + l.getIdUsuario()+ " / nome: " + l.getNome() 
                    + " / email: " + l.getEmail() + " / senha: " + l.getSenha() 
                    + " / ativo: " + l.isAtivo() + " / adm: " + l.isAdministrador());
        }
        System.out.println();
       
        System.out.println("LISTAGEM DE USUARIOS - POR ID");
        if(listagemPorId != null){
            System.out.println("idUsuario: " + listagemPorId.getIdUsuario()+ " / nome: " + listagemPorId.getNome() 
                    + " / email: " + listagemPorId.getEmail() + " / senha: " + listagemPorId.getSenha() 
                    + " / ativo: " + listagemPorId.isAtivo() + " / adm: " + listagemPorId.isAdministrador());
        }
        System.out.println();
        
        System.out.println("LISTAGEM DE USUARIOS - POR EMAIL");
        if(listagemPorEmail != null){
            System.out.println("idUsuario: " + listagemPorEmail.getIdUsuario()+ " / nome: " + listagemPorEmail.getNome() 
                    + " / email: " + listagemPorEmail.getEmail() + " / senha: " + listagemPorEmail.getSenha() 
                    + " / ativo: " + listagemPorEmail.isAtivo() + " / adm: " + listagemPorEmail.isAdministrador());
        }
        System.out.println();
    }
    
    public static void TesteConta(ContaBancariaDAO dao) throws PersistenciaException{
        
        long id = 11;
        long idUsuario = 2;
        long idBanco = 3;
        String descricao = "Conta teste";
        String numeroAgencia = "1234";
        String numeroConta = "1234567";
        float meta = 1000;
        
        ContaBancaria objeto = new ContaBancaria(id, idUsuario, idBanco, descricao, numeroAgencia, numeroConta, meta);
        
        //dao.inserir(objeto);
        //dao.alterar(objeto);
        //dao.remover(id);
        
        var listagem = dao.listar();
        var listagemPorId = dao.listarPorId(id);       
        var listagemPorUsuario = dao.listarPorUsuario(idUsuario, descricao);

            
        System.out.println("LISTAGEM DE USUARIOS - GERAL");
        for(ContaBancaria l : listagem){
            System.out.println("idConta: " + l.getIdContaBancaria()+ " / descricao: " + l.getDescricao()
                    + " / idUsuario: " + l.getUsuario().getIdUsuario() + " / idBanco: " + l.getBanco().getIdBanco()
                    + " / agencia: " + l.getNumeroAgencia() + " / conta: " + l.getNumeroConta()
                    + " / meta: " + l.getMeta());
        }
        System.out.println();
        
        System.out.println("LISTAGEM DE USUARIOS - POR ID");
        if(listagemPorId != null){
            System.out.println("idConta: " + listagemPorId.getIdContaBancaria()+ " / descricao: " + listagemPorId.getDescricao()
                    + " / idUsuario: " + listagemPorId.getUsuario().getIdUsuario() + " / idBanco: " + listagemPorId.getBanco().getIdBanco()
                    + " / agencia: " + listagemPorId.getNumeroAgencia() + " / conta: " + listagemPorId.getNumeroConta()
                    + " / meta: " + listagemPorId.getMeta());
        }
        System.out.println();
        
        System.out.println("LISTAGEM DE USUARIOS - POR USUARIO");
        for(ContaBancaria l : listagemPorUsuario){
            System.out.println("idConta: " + l.getIdContaBancaria()+ " / descricao: " + l.getDescricao()
                    + " / idUsuario: " + l.getUsuario().getIdUsuario() + " / idBanco: " + l.getBanco().getIdBanco()
                    + " / agencia: " + l.getNumeroAgencia() + " / conta: " + l.getNumeroConta()
                    + " / meta: " + l.getMeta());
        }
        System.out.println();

    }
    
    public static void TesteLancamentoCartao(LancamentoCartaoDAO dao) throws PersistenciaException{
        
        long id = 3;
        long idCartao = 5;
        LocalDate data = LocalDate.of(2023, Month.JANUARY, 25);
        float valor = 80;
        String comentario = "AAAA";
        
        LancamentoCartao objeto = new LancamentoCartao(id, idCartao, data, valor, comentario);
        
        //dao.inserir(objeto);
        //dao.alterar(objeto);
        //dao.remover(id);
        
        var listagem = dao.listar();
        var listagemPorId = dao.listarPorId(id); 
       
        System.out.println("LISTAGEM DE LANCAMENTO CARTAO - GERAL");
        for(LancamentoCartao l : listagem){
            System.out.println("idLancamento: " + l.getIdLancamentoCartao() + " / cartao: " + l.getCartao().getIdCartao()
                    + " / data: " + l.getDataLancamento() + " / valor: " + l.getValor()
                    + " / comentario: " + l.getComentario());
        }
        System.out.println();
        
        System.out.println("LISTAGEM DE LANCAMENTO CARTAO - POR ID");
        if(listagemPorId != null){
            System.out.println("idLancamento: " + listagemPorId.getIdLancamentoCartao() + " / cartao: " + listagemPorId.getCartao().getIdCartao()
                    + " / data: " + listagemPorId.getDataLancamento() + " / valor: " + listagemPorId.getValor()
                    + " / comentario: " + listagemPorId.getComentario());
        }
        System.out.println();
    }
  
    public static void TesteLancamentoConta(LancamentoContaDAO dao) throws PersistenciaException{
        long id = 2;
        long idConta = 11;
        long tipo = 1;
        LocalDate data = LocalDate.of(2023, Month.JANUARY, 25);
        float valor = 80;
        String comentario = "Teste";
        
        long idUsuario = 2;
        
        LancamentoConta objeto = new LancamentoConta(id, tipo, idConta, data, valor, comentario);
        
        //dao.inserir(objeto);
        //dao.alterar(objeto);
        //dao.remover(id);
        
        var listagem = dao.listar();
        var listagemPorId = dao.listarPorId(id); 
        var listagemPorUsuario = dao.listarPorUsuario(idUsuario);
        var listagemPorConta = dao.listarPorConta(idConta);
        var listagemDespesaPorConta = dao.listarDespesasPorConta(idConta);
        var listagemReceitaPorConta = dao.listarReceitasPorConta(idConta);
        var listagemDespesaPorUsuario = dao.listarDespesas(idUsuario);
        var listagemReceitaPorUsuario = dao.listarReceitas(idUsuario);
        
        System.out.println("LISTAGEM DE LANCAMENTO CONTA - GERAL");
        for(LancamentoConta l : listagem){
            System.out.println("idLancamento: " + l.getIdLancamentoConta() 
                    + " / tipo: " + l.getTipoLancamento().getIdTipoLancamento() 
                    + " / conta: " + l.getContaBancaria().getIdContaBancaria()
                    + " / data: " + l.getDataLancamento() 
                    + " / valor: " + l.getValor()
                    + " / comentario: " + l.getComentario());
        }
        System.out.println();
        
        System.out.println("LISTAGEM DE LANCAMENTO CONTA - POR ID");
        if(listagemPorId != null){
            System.out.println("idLancamento: " + listagemPorId.getIdLancamentoConta() 
                    + " / tipo: " + listagemPorId.getTipoLancamento().getIdTipoLancamento()
                    + " / conta: " + listagemPorId.getContaBancaria().getIdContaBancaria()
                    + " / data: " + listagemPorId.getDataLancamento() + " / valor: " + listagemPorId.getValor()
                    + " / comentario: " + listagemPorId.getComentario());
        }
        System.out.println();
        
        System.out.println("LISTAGEM DE LANCAMENTO CONTA - POR USUARIO");
        for(LancamentoConta l : listagemPorUsuario){
            System.out.println("idLancamento: " + l.getIdLancamentoConta() 
                    + " / tipo: " + l.getTipoLancamento().getIdTipoLancamento() 
                    + " / conta: " + l.getContaBancaria().getIdContaBancaria()
                    + " / data: " + l.getDataLancamento() 
                    + " / valor: " + l.getValor()
                    + " / comentario: " + l.getComentario());
        }
        System.out.println();
        
        System.out.println("LISTAGEM DE LANCAMENTO CONTA - POR CONTA");
        for(LancamentoConta l : listagemPorConta){
            System.out.println("idLancamento: " + l.getIdLancamentoConta() 
                    + " / tipo: " + l.getTipoLancamento().getIdTipoLancamento() 
                    + " / conta: " + l.getContaBancaria().getIdContaBancaria()
                    + " / data: " + l.getDataLancamento() 
                    + " / valor: " + l.getValor()
                    + " / comentario: " + l.getComentario());
        }
        System.out.println();
        
        System.out.println("LISTAGEM DE DESPESAS POR CONTA");
        for(LancamentoConta l : listagemDespesaPorConta){
            System.out.println("idLancamento: " + l.getIdLancamentoConta() 
                    + " / tipo: " + l.getTipoLancamento().getIdTipoLancamento() 
                    + " / conta: " + l.getContaBancaria().getIdContaBancaria()
                    + " / data: " + l.getDataLancamento() 
                    + " / valor: " + l.getValor()
                    + " / comentario: " + l.getComentario());
        }
        System.out.println();
        
        System.out.println("LISTAGEM DE RECEITA POR CONTA");
        for(LancamentoConta l : listagemReceitaPorConta){
            System.out.println("idLancamento: " + l.getIdLancamentoConta() 
                    + " / tipo: " + l.getTipoLancamento().getIdTipoLancamento() 
                    + " / conta: " + l.getContaBancaria().getIdContaBancaria()
                    + " / data: " + l.getDataLancamento() 
                    + " / valor: " + l.getValor()
                    + " / comentario: " + l.getComentario());
        }
        System.out.println();
        
        System.out.println("LISTAGEM DE DESPESA POR USUARIO");
        for(LancamentoConta l : listagemDespesaPorUsuario){
            System.out.println("idLancamento: " + l.getIdLancamentoConta() 
                    + " / tipo: " + l.getTipoLancamento().getIdTipoLancamento() 
                    + " / conta: " + l.getContaBancaria().getIdContaBancaria()
                    + " / data: " + l.getDataLancamento() 
                    + " / valor: " + l.getValor()
                    + " / comentario: " + l.getComentario());
        }
        System.out.println();
        
        System.out.println("LISTAGEM DE RECEITA POR USUARIO");
        for(LancamentoConta l : listagemReceitaPorUsuario){
            System.out.println("idLancamento: " + l.getIdLancamentoConta() 
                    + " / tipo: " + l.getTipoLancamento().getIdTipoLancamento() 
                    + " / conta: " + l.getContaBancaria().getIdContaBancaria()
                    + " / data: " + l.getDataLancamento() 
                    + " / valor: " + l.getValor()
                    + " / comentario: " + l.getComentario());
        }
        System.out.println();
        
    }
    
    public static void TesteTipoLancamento(TipoLancamentoDAO dao) throws PersistenciaException{
        
        long id = 1;
        String descricao = "despesa";
        
        TipoLancamento objeto = new TipoLancamento(id, descricao);
        
        //dao.inserir(objeto);
        //dao.alterar(objeto);
        //dao.remover(id);
        
        var listagem = dao.listar();
        var listagemPorId = dao.listarPorId(id);
        
        System.out.println("LISTAGEM DE LANCAMENTO CONTA - GERAL");
        for(TipoLancamento l : listagem){
            System.out.println("idTipo: " + l.getIdTipoLancamento() 
                    + " / descricao: " + l.getDescricao());
        }
        System.out.println();
        
        System.out.println("LISTAGEM DE LANCAMENTO CONTA - POR ID");
        if(listagemPorId != null){
            System.out.println("idTipo: " + listagemPorId.getIdTipoLancamento() 
                    + " / descricao: " + listagemPorId.getDescricao());
        }
        System.out.println();
               
    }
}
