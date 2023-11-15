package aplicacao;

import fxmls.FXMLRastreioController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMLRastreio extends Application{
    public void start(Stage stage){}
    public void start(Stage stage, String codigo) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxmls/rastreio.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        stage.setTitle("ESSE É O SEU CÓDIGO!");
        stage.setResizable(false);
        stage.getIcons().add(new javafx.scene.image.Image("/imagens/addpacote_icone.png"));

        FXMLRastreioController controller = fxmlLoader.getController();
        controller.setCodigo(codigo);

        stage.setScene(scene);
        stage.show();
    }
}
