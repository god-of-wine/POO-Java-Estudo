package aplicacao;

// imports de arquivos locais
import aplicacao.fxml.UImenuPrincipal;
import servicos.gerais.ServicosBancoDeDados;
import entidades.pacote.Pacote;

// imports do javafx
import javafx.application.Application;
import javafx.stage.*;

// outros imports
import java.util.ArrayList;


public class Programa extends Application{
    public static void main(String[] args) throws Exception	{
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        // atualizando os status de entrega dos pacotes no banco de dados
        ArrayList<Pacote> lista = new ArrayList<>();
        ServicosBancoDeDados sbd = new ServicosBancoDeDados();
        sbd.createList(lista);
        sbd.atualizaStatus(lista);
        sbd.updateBanco(lista);

        // inicioando a janela do menu principal
        UImenuPrincipal menuPrincipal = new UImenuPrincipal();
        menuPrincipal.start(stage);
    }
}
