
package br.edu.fesa.vaievem.services;

import br.edu.fesa.vaievem.dao.ContaBancariaDAO;
import br.edu.fesa.vaievem.dao.interfaces.IContaBancariaDAO;
import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.ContaBancaria;
import br.edu.fesa.vaievem.models.Mensagem;
import br.edu.fesa.vaievem.models.Usuario;
import br.edu.fesa.vaievem.services.interfaces.ILancamentoContaService;
import br.edu.fesa.vaievem.services.interfaces.IMensagemService;
import br.edu.fesa.vaievem.utils.Session;
import java.util.List;


public class MensagemService implements IMensagemService {

    private final IContaBancariaDAO _contaBancariaDAO = new ContaBancariaDAO();
    private final ILancamentoContaService _lancamentoContaService = new LancamentoContaService();
    
    private final float LIMITE_META = 1.1F;
    
    private Usuario retornaUsuarioSession() throws LogicalException { 
        Usuario retorno = Session.getUsuarioLogado();
        
        if(retorno == null){
            throw new LogicalException("Nenhum usuário logado na Session");
        }
        
        return retorno;
    }
    
    @Override
    public Mensagem retornaMensagemMeta() throws PersistenciaException, LogicalException {
        String titulo = "Parabéns!";
        String mensagem = "Todas as suas contas estão com saldo acima da meta!";
        
        Usuario usuario = retornaUsuarioSession();
        List<ContaBancaria> contas = _contaBancariaDAO.listarPorUsuario(usuario.getIdUsuario(), null);
        double saldo;
        
        if(contas.isEmpty()){
            return new Mensagem("Atenção!", "Cadastre uma conta para cálculo da Meta!");
        }
        
        for(ContaBancaria conta : contas){
            saldo = _lancamentoContaService.retornaSaldoPorConta(conta.getIdContaBancaria());
            
            if(saldo < conta.getMeta()){
                return new Mensagem("Alerta!", "Existem contas cujo saldo está inferior à meta!");
            }
            
            if(saldo <= conta.getMeta() * LIMITE_META){
                titulo = "Atenção!";
                mensagem = "Existem contas cujo saldo está próximo à meta!";
            }
        }
        
        return new Mensagem(titulo, mensagem);
    }
    
}
