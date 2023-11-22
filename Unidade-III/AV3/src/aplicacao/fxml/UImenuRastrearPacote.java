// Classe que inicializa a aba de Rastrear Pacotes

package aplicacao.fxml;

import java.util.ArrayList;

import entidades.pacote.Pacote;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import userinterface.controller.menuRastrearPacoteController;

public class UImenuRastrearPacote extends Application{
    public void start(Stage stage){}
    public void start(Stage stage, ArrayList<Pacote> lista) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/userinterface/fxml/menuRastrearPacote.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        stage.setTitle("Rastrear Pacotes - POO");
        stage.setResizable(false);
        stage.getIcons().add(new javafx.scene.image.Image("/imagens/icone/editarPacote_icone.png"));

        menuRastrearPacoteController fxmlRPC = fxmlLoader.getController();
        fxmlRPC.setListaBBD(lista);

        stage.setScene(scene);
        stage.show();
    }
}
