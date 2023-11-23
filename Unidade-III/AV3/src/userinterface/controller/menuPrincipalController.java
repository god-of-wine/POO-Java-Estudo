package userinterface.controller;

import java.util.ArrayList;

import aplicacao.fxml.UIadicionarPacote;
import aplicacao.fxml.UImenuEditarPacote;
import aplicacao.fxml.UIconhecaEquipe;
import aplicacao.fxml.UImenuRastrearPacote;
import entidades.pacote.Pacote;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import servicos.gerais.ServicosBancoDeDados;

public class menuPrincipalController {

    @FXML
    private Button addPacoteBotao;
    
    // esse método é chamado quando o botão é pressionado no fxml (abrindo a janela de adicionar pacote)
    @FXML
    private void addPacoteBotaoAcao(ActionEvent event) throws Exception{
        UIadicionarPacote fxmlAddPacote = new UIadicionarPacote();

        fxmlAddPacote.start(new Stage());
    }

    @FXML
    private Button editPacoteBotao;

    // esse método é chamado quando o botão é pressionado no fxml (abrindo a janela de editar pacote)
    @FXML
    private void editPacoteBotaoAcao(ActionEvent event) throws Exception{
        UImenuEditarPacote fxmlEditPacote = new UImenuEditarPacote();
        ArrayList<Pacote> lista = new ArrayList<>();
        ServicosBancoDeDados sdb = new ServicosBancoDeDados();
        sdb.createList(lista);
        fxmlEditPacote.start(new Stage(), lista);
    }

    @FXML
    private Button equipeBotao;

    // esse método é chamado quando o botão é pressionado no fxml (abrindo a janela que mostra a equipe)
    @FXML
    private void equipeBotaoAcao(ActionEvent event) throws Exception{
        UIconhecaEquipe fxmlEquipe = new UIconhecaEquipe();

        fxmlEquipe.start(new Stage());
    }

    @FXML
    private Button rastrearPacoteBotao;

    // esse método é chamado quando o botão é pressionado no fxml (abrindo a janela de rastrear pacotes)
    @FXML
    private void rastrearPacoteBotaoAcao(ActionEvent event) throws Exception{
        UImenuRastrearPacote fxmlRastrearPacote = new UImenuRastrearPacote();
        ArrayList<Pacote> lista = new ArrayList<>();
        ServicosBancoDeDados sdb = new ServicosBancoDeDados();
        sdb.createList(lista);
        fxmlRastrearPacote.start(new Stage(), lista);
    }

}
