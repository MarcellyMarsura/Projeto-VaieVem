
package br.edu.fesa.vaievem.main;

import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.Banco;
import br.edu.fesa.vaievem.models.Cartao;
import br.edu.fesa.vaievem.models.ContaBancaria;
import br.edu.fesa.vaievem.models.LancamentoConta;
import br.edu.fesa.vaievem.models.TipoLancamento;
import br.edu.fesa.vaievem.models.Usuario;
import br.edu.fesa.vaievem.services.BancoService;
import br.edu.fesa.vaievem.services.CartaoService;
import br.edu.fesa.vaievem.services.ContaBancariaService;
import br.edu.fesa.vaievem.services.LancamentoContaService;
import br.edu.fesa.vaievem.services.MensagemService;
import br.edu.fesa.vaievem.services.TipoLancamentoService;
import br.edu.fesa.vaievem.services.UsuarioService;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;


public class Main {
    
    private static final UsuarioService usuarioService = new UsuarioService();
    private static final BancoService bancoService = new BancoService();
    private static final ContaBancariaService contaService = new ContaBancariaService();
    private static final TipoLancamentoService tipoLancamentoService = new TipoLancamentoService();
    private static final LancamentoContaService lancamentoContaService = new LancamentoContaService();
    private static final MensagemService mensagemService = new MensagemService();
    private static final CartaoService cartaoService = new CartaoService();
    
    public static void main(String[] args) {
        
        try{ 
            TesteUsuario();
            //TesteConta();
            //TesteLancamento();
            TesteMensagem();
            //TesteCartao();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    private static void TesteUsuario() throws PersistenciaException, LogicalException {
        if(usuarioService.autenticaUsuario(new Usuario("b@email.com", "123"))){
            System.out.println("Usuário autenticado");
        }
    }
    
    private static void TesteConta() throws PersistenciaException, LogicalException {
        List<Banco> bancos = bancoService.listar();
        
        ContaBancaria nova = new ContaBancaria();
        nova.setDescricao("Conta Poupança Bradesco");
        nova.setMeta(500);
        nova.setBanco(bancos.get(1));
        
        
        contaService.inserir(nova);
        
        List<ContaBancaria> contas = contaService.listarPorUsuario();
    }
    
    private static void TesteLancamento() throws PersistenciaException, LogicalException {
        List<TipoLancamento> tipos = tipoLancamentoService.listar();
        List<ContaBancaria> contas = contaService.listarPorUsuario();
        
        LancamentoConta novo = new LancamentoConta();
        novo.setTipoLancamento(tipos.get(0));
        novo.setValor(10);
        novo.setComentario("Presente");
        novo.setDataLancamento(LocalDate.of(2023, Month.NOVEMBER, 25));
        novo.setContaBancaria(contas.get(0));
        
        lancamentoContaService.inserir(novo);
    }
    
    private static void TesteMensagem()  throws PersistenciaException, LogicalException{
        System.out.println(mensagemService.retornaMensagemMeta().getCorpo());
    }
    
    private static void TesteCartao() throws PersistenciaException, LogicalException {
        List<ContaBancaria> contas = contaService.listarPorUsuario();
        
        Cartao novo = new Cartao();
        novo.setContaBancaria(contas.get(0));
        novo.setDescricao("Cartão de débito Itaú");
        novo.setDiaFechamento(5);
        novo.setDiaVencimento(10);
        novo.setLimiteEstipulado(100);
        
        cartaoService.inserir(novo);
    }
}