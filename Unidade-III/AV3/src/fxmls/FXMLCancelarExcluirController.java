package fxmls;

import java.util.ArrayList;

import aplicacao.FXMLEditPacote;
import entidades.Pacote;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import servicos.ServicosBancoDeDados;

public class FXMLCancelarExcluirController {
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

    @FXML
    private void cancelarBotaoAcao(ActionEvent e) throws Exception{
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private Button excluirBotao;

    @FXML
    private void excluirBotaoAcao(ActionEvent e) throws Exception{
        listaBDD.remove(pacote);
        ServicosBancoDeDados sbd = new ServicosBancoDeDados();
        sbd.updateBanco(listaBDD);
        fonte.close();
        FXMLEditPacote fxmlMPE = new FXMLEditPacote();
        fxmlMPE.start(new Stage(), listaBDD);
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private TextArea textArea;

}
