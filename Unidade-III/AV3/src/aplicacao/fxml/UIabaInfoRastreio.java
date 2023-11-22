package aplicacao.fxml;

// imports de arquivos locais
import userinterface.controller.abaInfoRastreioController;

// imports do javafx
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UIabaInfoRastreio {
    /* definindo um método start que não fará nada,
       pois ao extender Application, há a exigência deste método
       apesar de não usarmos */
    public void start(Stage stage){}

    /* definindo um método start que recebe um Pacote e
       uma String. Este será o método start que usaremos */
    public void start(Stage stage, String texto) throws Exception {

        // carregando o fxml com FXMLLoader
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/userinterface/fxml/abaInfoRastreio.fxml"));
        Parent root = fxmlLoader.load();

        // configurando o Controller do fxml
        abaInfoRastreioController fxmlPARController = fxmlLoader.getController();
        fxmlPARController.setInfo(texto);

        // tornando visível ao usuário
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}
