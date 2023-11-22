// Classe que inicializa a aba de Adicionar Pacotes

package aplicacao.fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UIadicionarPacote extends Application{
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/userinterface/fxml/adicionarPacote.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        stage.setTitle("Adicionar Pacote - POO");
        stage.setResizable(false);
        stage.getIcons().add(new javafx.scene.image.Image("/imagens/icone/addpacote_icone.png"));

        stage.setScene(scene);
        stage.show();
    }
}
