package userinterface.controller;

// imports de arquivos locais
import aplicacao.fxml.UImenuEditarPacote;
import entidades.pacote.Pacote;
import servicos.gerais.ServicosBancoDeDados;

// imports do javafx
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

// outros imports
import java.util.ArrayList;

public class abaCancelarExcluirController {
    private Pacote pacote;
    private ArrayList<Pacote> listaBDD;
    private Stage fonte;

    public void setPacote(Pacote pacote, ArrayList<Pacote> listaBDD, Stage fonte){
        this.pacote = pacote;
        this.listaBDD = listaBDD;
        this.fonte = fonte;
        textArea.setText(pacote.toString());
    }
    
    @FXML
    private Button cancelarBotao;

    // esse método é chamado quando o botão é pressionado no fxml
    @FXML
    private void cancelarBotaoAcao(ActionEvent e) throws Exception{
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private Button excluirBotao;

    // esse método é chamado quando o botão é pressionado no fxml
    @FXML
    private void excluirBotaoAcao(ActionEvent e) throws Exception{
        listaBDD.remove(pacote);
        ServicosBancoDeDados sbd = new ServicosBancoDeDados();
        sbd.updateBanco(listaBDD);
        fonte.close();
        UImenuEditarPacote fxmlMPE = new UImenuEditarPacote();
        fxmlMPE.start(new Stage(), listaBDD);
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private TextArea textArea;

}
