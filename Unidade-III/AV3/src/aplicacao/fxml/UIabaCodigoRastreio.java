package aplicacao.fxml;

// imports de arquivos locais
import userinterface.controller.abaCodigoRastreioController;

// imports do javafx
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class UIabaCodigoRastreio extends Application{
    /* definindo um método start que não fará nada,
       pois ao extender Application, há a exigência deste método
       apesar de não usarmos */
    public void start(Stage stage){}

    /* definindo um método start que recebe um Pacote e 
       uma String. Este será o método que usaremos */
    public void start(Stage stage, String codigo) throws Exception {

        // carregando o fxml com FXMLLoader
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/userinterface/fxml/abaCodigoRastreio.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        // configurando a janela de exibição
        stage.setTitle("ESSE É O SEU CÓDIGO!");
        stage.setResizable(false);
        stage.getIcons().add(new javafx.scene.image.Image("/imagens/icone/addpacote_icone.png"));

        // configurando o Controller do fxml
        abaCodigoRastreioController controller = fxmlLoader.getController();
        controller.setCodigo(codigo);

        // tornando visível ao usuário
        stage.setScene(scene);
        stage.show();
    }
}
