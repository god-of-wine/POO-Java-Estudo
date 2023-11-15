package fxmls;

import aplicacao.FXMLAddPacote;
import aplicacao.FXMLEditPacote;
import aplicacao.FXMLEquipe;
import aplicacao.FXMLRastrearPacote;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FXMLMenuPrincipalController {

    @FXML
    private Button addPacoteBotao;
    
    @FXML // Adicionando a ação ao clicar no botão
    private void addPacoteBotaoAcao(ActionEvent event) throws Exception{
        FXMLAddPacote fxmlAddPacote = new FXMLAddPacote();

        fxmlAddPacote.start(new Stage());
    }

    @FXML
    private Button editPacoteBotao;

    @FXML // Adicionando a ação ao clicar no botão
    private void editPacoteBotaoAcao(ActionEvent event) throws Exception{
        FXMLEditPacote fxmlEditPacote = new FXMLEditPacote();

        fxmlEditPacote.start(new Stage());
    }

    @FXML
    private Button equipeBotao;

    @FXML // Adicionando a ação ao clicar no botão
    private void equipeBotaoAcao(ActionEvent event) throws Exception{
        FXMLEquipe fxmlEquipe = new FXMLEquipe();

        fxmlEquipe.start(new Stage());
    }

    @FXML
    private Button rastrearPacoteBotao;

    @FXML // Adicionando a ação ao clicar no botão
    private void rastrearPacoteBotaoAcao(ActionEvent event) throws Exception{
        FXMLRastrearPacote fxmlRastrearPacote = new FXMLRastrearPacote();

        fxmlRastrearPacote.start(new Stage());
    }

}
