package aplicacao.fxml;

// imports do javafx
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UIconhecaEquipe extends Application{
    /* definindo um método start que recebe um Stage
       Este será o método start que usaremos */
    public void start(Stage stage) throws Exception{

        // carregando o fxml com FXMLLoader
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/userinterface/fxml/conhecaEquipe.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        // configurando a janela de exibição
        stage.setTitle("Conheça a Equipe - POO");
        stage.setResizable(false);
        stage.getIcons().add(new javafx.scene.image.Image("/imagens/icone/infoEquipe_icone.png"));

        // tornando visível ao usuário
        stage.setScene(scene);
        stage.show();
    }
}
