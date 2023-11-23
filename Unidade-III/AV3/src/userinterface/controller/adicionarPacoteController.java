package userinterface.controller;

// imports de arquivos locais
import aplicacao.fxml.UIabaCodigoRastreio;
import grafo.Grafo;
import servicos.frete_entrega.FreteEconomico;
import servicos.frete_entrega.FreteExpresso;
import servicos.frete_entrega.StatusEntrega;
import servicos.frete_entrega.TipoEntrega;
import servicos.gerais.ServicosBancoDeDados;
import servicos.gerais.ServicosGrafos;

// imports do javafx
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

// outos imports
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class adicionarPacoteController implements Initializable{
    // esses itens serão usados por mais de uma função, portanto serão criados aqui
    Double frete, dias;

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
        String codRastreio  = sbd.geraRastreio();
        sbd.addPacote(descricaoField.getText(), Integer.parseInt(alturaField.getText()), Integer.parseInt(larguraField.getText()), Integer.parseInt(comprimentoField.getText()), Integer.parseInt(pesoField.getText()), nomeRemetenteField.getText(), cepRemetenteField.getText(), nomeDestinatarioField.getText(), cepDestinatarioField.getText(), cpfDestinatarioField.getText(), enderecoArea.getText(), codRastreio, frete, dias, freteComboBox.getSelectionModel().getSelectedItem(), StatusEntrega.PAGAMENTO_PENDENTE, java.sql.Date.valueOf(LocalDate.now()), java.sql.Date.valueOf(LocalDate.now().plusDays(dias.intValue())));
        
        UIabaCodigoRastreio fxmlRastreio = new UIabaCodigoRastreio();
        fxmlRastreio.start(new Stage(), codRastreio);

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
    private ComboBox<TipoEntrega> freteComboBox;
    
    /* Esse método atualiza o campo que informa
       o frete e o prazo, sempre que a opção no
       combobox for alterada */
    private FreteEconomico freteco = new FreteEconomico();
    private FreteExpresso fretex = new FreteExpresso();
    private Grafo grafo = new Grafo(10);
    private ServicosGrafos sergra = new ServicosGrafos();
    @FXML 
    private void atualizarFreteEPrazo(){
        sergra.IniciaGrafoBrasil(grafo);
        if(freteComboBox.getSelectionModel().getSelectedItem()==TipoEntrega.ECONOMICA){
            frete = freteco.CalculaFrete(Integer.parseInt(alturaField.getText()), Integer.parseInt(larguraField.getText()), Integer.parseInt(comprimentoField.getText()), Integer.parseInt(pesoField.getText()), sergra.Dijkstra(grafo, Character.getNumericValue(cepDestinatarioField.getText().charAt(0)), Character.getNumericValue(cepRemetenteField.getText().charAt(0))));
            dias = freteco.CalculaPrazo(sergra.Dijkstra(grafo, Character.getNumericValue(cepDestinatarioField.getText().charAt(0)), Character.getNumericValue(cepRemetenteField.getText().charAt(0))));
        } else {
            frete = fretex.CalculaFrete(Integer.parseInt(alturaField.getText()), Integer.parseInt(larguraField.getText()), Integer.parseInt(comprimentoField.getText()), Integer.parseInt(pesoField.getText()), sergra.Dijkstra(grafo, Character.getNumericValue(cepDestinatarioField.getText().charAt(0)), Character.getNumericValue(cepRemetenteField.getText().charAt(0))));
            dias = fretex.CalculaPrazo(sergra.Dijkstra(grafo, Character.getNumericValue(cepDestinatarioField.getText().charAt(0)), Character.getNumericValue(cepRemetenteField.getText().charAt(0))));
        }
        freteComboBox.setOnAction(event -> {
            freteEPrazoLabel.setText(String.format("Frete: R$ %.2f | %.0f dia(s)",frete ,Math.ceil(dias)));
        });
    }

    @FXML
    private Label freteEPrazoLabel;

    @FXML
    private TextField larguraField;

    @FXML
    private TextField nomeDestinatarioField;

    @FXML
    private TextField nomeRemetenteField;

    @FXML
    private TextField pesoField;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        loadComboBox();
        freteComboBox.valueProperty().addListener((obs, oldVal, newVal) -> {
            atualizarFreteEPrazo();
        });
    }

    private List<TipoEntrega> categorias = new ArrayList<>();

    // esse método insere os itens na ComboBox
    public void loadComboBox(){
        categorias.add(TipoEntrega.ECONOMICA);
        categorias.add(TipoEntrega.EXPRESSA);

        freteComboBox.setItems(FXCollections.observableArrayList(categorias));
    }

}
