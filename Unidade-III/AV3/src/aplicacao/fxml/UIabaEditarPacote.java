package aplicacao.fxml;

import java.util.ArrayList;

import entidades.pacote.Pacote;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import userinterface.controller.abaEditarPacoteController;

public class UIabaEditarPacote {
    public void start(Stage stage){}
    public void start(Stage stage, Pacote pacote, ArrayList<Pacote> lista, Stage fonte) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/userinterface/fxml/abaEditarPacote.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        abaEditarPacoteController fxmlMEPC = fxmlLoader.getController();
        fxmlMEPC.setPacoteLista(pacote, lista, fonte);

        stage.setTitle("Editar Pacote - POO");
        stage.setResizable(false);
        stage.getIcons().add(new javafx.scene.image.Image("/imagens/icone/editarPacote_icone.png"));

        stage.setScene(scene);
        stage.show();
    }
}
