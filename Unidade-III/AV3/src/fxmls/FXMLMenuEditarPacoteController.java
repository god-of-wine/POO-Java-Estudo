package fxmls;

import java.net.URL;
import java.util.ResourceBundle;

import entidades.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import servicos.ServicosBancoDeDados;

public class FXMLMenuEditarPacoteController implements Initializable{
    private Pacote pacote;

    public FXMLMenuEditarPacoteController (Pacote pacote){
        this.pacote = pacote;
    }

    public void loadEdit(){
        alturaField.setText(Integer.toString(pacote.getDimensao().getAltura()));
        descricaoField.setText(pacote.getDescricao());
        pesoField.setText(Integer.toString(pacote.getPeso()));
        nomeRemetenteField.setText(pacote.getNome_remetente());
        cepRemetenteField.setText(pacote.getCep_remetente());
        nomeDestinatarioField.setText(pacote.getNome_destinatario());
        cepDestinatarioField.setText(pacote.getCep_destinatario());
        cpfDestinatarioField.setText(pacote.getCpf_destinatario());
        enderecoArea.setText(pacote.getEndereco());
        tipoFretePrazoField.setText(String.format("Tipo: %s | Frete: R$ %.2f | %.0f dia(s)", pacote.getTipo_entrega().getNome(), pacote.getFrete(), pacote.getDias()));
    
        if(pacote.getDimensao() instanceof DimensaoCaixa){
            larguraField.setText(Integer.toString(((DimensaoCaixa) pacote.getDimensao()).getLargura()));
            comprimentoField.setText(Integer.toString(((DimensaoCaixa) pacote.getDimensao()).getComprimento()));
        } else {
            larguraField.setText(Integer.toString(((DimensaoCilindro) pacote.getDimensao()).getDiametro()));
            comprimentoField.setText("0");
        }
    }

    @FXML
    private TextField alturaField;

    @FXML
    private TextField cepDestinatarioField;

    @FXML
    private TextField cepRemetenteField;

    @FXML
    private TextField comprimentoField;

    @FXML
    private Button concluirBotao;

    ServicosBancoDeDados sbd = new ServicosBancoDeDados();
    @FXML
    private void concluirBotaoAcao(ActionEvent event){
        pacote.setDescricao(descricaoField.getText());
        pacote.setNome_remetente(nomeRemetenteField.getText());
        pacote.setNome_destinatario(nomeDestinatarioField.getText());
        pacote.setCpf_destinatario(cpfDestinatarioField.getText());
        
        // fecho a aba quando aperto no botão de concluir
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private TextField cpfDestinatarioField;

    @FXML
    private TextField descricaoField;

    @FXML
    private TextArea enderecoArea;

    @FXML
    private TextField larguraField;

    @FXML
    private TextField nomeDestinatarioField;

    @FXML
    private TextField nomeRemetenteField;

    @FXML
    private TextField pesoField;

    @FXML
    private TextField tipoFretePrazoField;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        loadEdit();
    }
}
