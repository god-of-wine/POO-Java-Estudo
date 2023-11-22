package aplicacao;

import java.util.ArrayList;

import entidades.Pacote;
import fxmls.FXMLMenuEditarPacoteController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMLMenuEditarPacote {
    public void start(Stage stage){}
    public void start(Stage stage, Pacote pacote, ArrayList<Pacote> lista, Stage fonte) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxmls/menu_editarpacote.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        FXMLMenuEditarPacoteController fxmlMEPC = fxmlLoader.getController();
        fxmlMEPC.setPacoteLista(pacote, lista, fonte);

        stage.setTitle("Editar Pacote - POO");
        stage.setResizable(false);
        stage.getIcons().add(new javafx.scene.image.Image("/imagens/editarPacote_icone.png"));

        stage.setScene(scene);
        stage.show();
    }
}
