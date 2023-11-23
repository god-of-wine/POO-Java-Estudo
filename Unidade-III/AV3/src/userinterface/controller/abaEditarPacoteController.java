package userinterface.controller;

// imports de arquivos locais
import aplicacao.fxml.UImenuEditarPacote;
import entidades.pacote.DimensaoCaixa;
import entidades.pacote.DimensaoCilindro;
import entidades.pacote.Pacote;
import servicos.gerais.ServicosBancoDeDados;

// imports do javafx
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

// outros imports
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class abaEditarPacoteController implements Initializable{
    private Pacote pacote;
    private ArrayList<Pacote> listaBBD;
    private Stage fonte;

    public void setPacoteLista (Pacote pacote, ArrayList<Pacote> lista, Stage fonte){
        this.pacote = pacote;
        this.listaBBD = lista;
        this.fonte = fonte;
        loadEdit();
    }

    // essa função carrega as informações do pacote no fxml 
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

    // esse método é chamado quando o botão é pressionado no fxml
    ServicosBancoDeDados sbd = new ServicosBancoDeDados();
    @FXML
    private void concluirBotaoAcao(ActionEvent event) throws Exception{
        pacote.setDescricao(descricaoField.getText());
        pacote.setNome_remetente(nomeRemetenteField.getText());
        pacote.setNome_destinatario(nomeDestinatarioField.getText());
        pacote.setCpf_destinatario(cpfDestinatarioField.getText());

        sbd.updateBanco(listaBBD);
        fonte.close();
        UImenuEditarPacote fxmlMPE = new UImenuEditarPacote();
        fxmlMPE.start(new Stage(), listaBBD);
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
    }
}
