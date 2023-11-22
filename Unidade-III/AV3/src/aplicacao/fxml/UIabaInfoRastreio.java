package aplicacao.fxml;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import userinterface.controller.abaInfoRastreioController;

public class UIabaInfoRastreio {
    public void start(Stage stage){}
    public void start(Stage stage, String texto) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/userinterface/fxml/abaInfoRastreio.fxml"));
        Parent root = fxmlLoader.load();

        abaInfoRastreioController fxmlPARController = fxmlLoader.getController();
        fxmlPARController.setInfo(texto);

        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}
