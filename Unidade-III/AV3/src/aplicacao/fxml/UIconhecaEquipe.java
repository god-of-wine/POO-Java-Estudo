// Classe que inicializa a aba de Mostrar a Equipe

package aplicacao.fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UIconhecaEquipe extends Application{
    public void start(Stage stage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/userinterface/fxml/conhecaEquipe.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        stage.setTitle("Conheça a Equipe - POO");
        stage.setResizable(false);
        stage.getIcons().add(new javafx.scene.image.Image("/imagens/icone/infoEquipe_icone.png"));

        stage.setScene(scene);
        stage.show();
    }
}
