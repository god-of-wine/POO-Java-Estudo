package aplicacao;

import java.util.ArrayList;

import aplicacao.fxml.UImenuPrincipal;
import entidades.pacote.Pacote;
import javafx.application.Application;
import javafx.stage.*;
import servicos.gerais.ServicosBancoDeDados;

public class Programa extends Application{
    public static void main(String[] args) throws Exception	{
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ArrayList<Pacote> lista = new ArrayList<>();
        ServicosBancoDeDados sbd = new ServicosBancoDeDados();
        sbd.createList(lista);
        sbd.atualizaStatus(lista);
        sbd.updateBanco(lista);
        UImenuPrincipal menuPrincipal = new UImenuPrincipal();
        menuPrincipal.start(stage);
    }
}
