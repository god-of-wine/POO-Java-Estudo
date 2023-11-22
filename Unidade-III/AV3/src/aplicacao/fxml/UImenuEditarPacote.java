// Classe que inicializa a aba de Editar Pacotes

package aplicacao.fxml;

import java.util.ArrayList;

import entidades.pacote.Pacote;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import userinterface.controller.menuEditarPacoteController;

public class UImenuEditarPacote {
    public void start(Stage stage){}
    public void start(Stage stage, ArrayList<Pacote> lista) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/userinterface/fxml/menuEditarPacote.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        stage.setTitle("Editar/Excluir Pacotes - POO");
        stage.setResizable(false);
        stage.getIcons().add(new javafx.scene.image.Image("/imagens/icone/editarPacote_icone.png"));

        menuEditarPacoteController fxmlEPController = fxmlLoader.getController();
        fxmlEPController.setListaBBD(lista, stage);

        stage.setScene(scene);
        stage.show();
    }
}
