
package br.edu.fesa.vaievem.controller;

import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.mockService.LancamentoContaService;
import br.edu.fesa.vaievem.models.ContaBancaria;
import br.edu.fesa.vaievem.models.LancamentoConta;
import br.edu.fesa.vaievem.models.TipoLancamento;
import br.edu.fesa.vaievem.services.ContaBancariaService;
import br.edu.fesa.vaievem.services.TipoLancamentoService;
import br.edu.fesa.vaievem.services.interfaces.IContaBancariaService;
import br.edu.fesa.vaievem.services.interfaces.ILancamentoContaService;
import br.edu.fesa.vaievem.services.interfaces.ITipoLancamentoService;
import br.edu.fesa.vaievem.utils.FormatString;
import br.edu.fesa.vaievem.utils.MessageBox;
import br.edu.fesa.vaievem.utils.Tela;
import br.edu.fesa.vaievem.utils.ViewConfiguration;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CadastroLancamentoContaController implements Initializable {

    @FXML
    private ComboBox<ContaBancaria> cbConta;

    @FXML
    private ComboBox<TipoLancamento> cbTipoLancamento;

    @FXML
    private DatePicker txtData;

    @FXML
    private TextField txtValor;

    @FXML
    private TextArea txtComentario;

    IContaBancariaService _contaBancariaService;
    ITipoLancamentoService _tipoLancamentoService;
    ILancamentoContaService _lancamentoContaService;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            _contaBancariaService = new ContaBancariaService();
            _tipoLancamentoService = new TipoLancamentoService();
            _lancamentoContaService = new LancamentoContaService();
            configurarTela();
        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }
    }

    private void configurarTela() {
        try {
            cbConta.setItems(_contaBancariaService.listarComboBox());
            cbTipoLancamento.setItems(_tipoLancamentoService.listarComboBox());
            txtValor.setTextFormatter(FormatString.formataInputDouble());
        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }
    }

    @FXML
    private void onMouseClicked_btnVoltar() throws IOException {
        try {
            ViewConfiguration.mudaTela(Tela.HOME.getNome());
        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }
    }

    @FXML
    private void onMouseClicked_btnSalvar() throws IOException {
        try {
            ContaBancaria conta = cbConta.getValue();
            TipoLancamento tipoLancamento = cbTipoLancamento.getValue();
            LocalDate data = txtData.getValue();
            Float valor = txtValor.getText().trim().isEmpty() ? 0F : Float.valueOf(txtValor.getText().trim());
            String comentario = txtComentario.getText().trim();

            if (conta == null || tipoLancamento == null || data == null) {
                throw new LogicalException("Preencha todos os campos obrigatórios.");
            }
            if (valor == 0f) {
                throw new LogicalException("O valor não pode ser igual a zero.");
            }
            if (data.isAfter(LocalDate.now())) {
                throw new LogicalException("Data inválida");
            }

            LancamentoConta novoLancamento = new LancamentoConta();
            novoLancamento.setContaBancaria(conta);
            novoLancamento.setTipoLancamento(tipoLancamento);
            novoLancamento.setDataLancamento(data);
            novoLancamento.setValor(valor);
            novoLancamento.setComentario(comentario);

            _lancamentoContaService.inserir(novoLancamento);

            ViewConfiguration.mudaTela(Tela.HOME.getNome());

        } catch (LogicalException erro) {
            MessageBox.exibeAlerta(erro.getMessage());
        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }
    }

}
