package fxmls;

import java.util.ArrayList;

import aplicacao.FXMLCancelarExcluir;
import aplicacao.FXMLMenuEditarPacote;
import entidades.Pacote;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class FXMLPainelEditarExcluirController {
    private Pacote pacote;
    private ArrayList<Pacote> listaBBD;
    private Stage stage;

    public void setLista(ArrayList<Pacote> lista){
        listaBBD = lista;
    }

    public void setPacote(Pacote pacote){
        this.pacote = pacote;
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }

    @FXML
    private Button deletarBotao;

    @FXML
    private void deletarBotaoAcao(ActionEvent e) throws Exception{
        FXMLCancelarExcluir fxmlCE = new FXMLCancelarExcluir();
        fxmlCE.start(new Stage(), pacote, listaBBD, stage);
    }

    @FXML
    private Button editarBotao;

    @FXML
    private void editarBotaoAcao(ActionEvent e) throws Exception{
        FXMLMenuEditarPacote fxmlMEP = new FXMLMenuEditarPacote();
        fxmlMEP.start(new Stage(), pacote, listaBBD, stage);
    }

    @FXML
    private TextArea infoPacoteArea;

    public void setInfo(String info){
        infoPacoteArea.setText(info);
    }

}
