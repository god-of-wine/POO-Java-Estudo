// Classe que inicializa a aba de Editar Pacotes

package aplicacao;

import java.util.ArrayList;

import entidades.Pacote;
import fxmls.FXMLEditPacoteController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMLEditPacote {
    public void start(Stage stage){}
    public void start(Stage stage, ArrayList<Pacote> lista) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxmls/editarpacote.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        stage.setTitle("Editar/Excluir Pacotes - POO");
        stage.setResizable(false);
        stage.getIcons().add(new javafx.scene.image.Image("/imagens/editarPacote_icone.png"));

        FXMLEditPacoteController fxmlEPController = fxmlLoader.getController();
        fxmlEPController.setListaBBD(lista, stage);

        stage.setScene(scene);
        stage.show();
    }
}
