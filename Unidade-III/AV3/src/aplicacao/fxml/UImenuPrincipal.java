// Classe que inicializa a aba do Menu Principal
package aplicacao.fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

public class UImenuPrincipal extends Application{
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/userinterface/fxml/menuPrincipal.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        stage.setTitle("Centro de Logística - POO");
        stage.setResizable(false);
        stage.getIcons().add(new javafx.scene.image.Image("/imagens/geral/icone.png"));

        stage.setScene(scene);
        stage.show();
    }
}
