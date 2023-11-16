package aplicacao;

import fxmls.FXMLPainelAuxiliarRastreioController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMLPainelAuxiliarRastreio {
    public void start(Stage stage){}
    public void start(Stage stage, String texto) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxmls/painelauxiliarrastrear.fxml"));
        Parent root = fxmlLoader.load();

        FXMLPainelAuxiliarRastreioController fxmlPARController = fxmlLoader.getController();
        fxmlPARController.setInfo(texto);

        Scene scene = new Scene(root);

        stage.setScene(scene);
    }
}
