package aplicacao.fxml;

// imports de arquivos locais
import entidades.pacote.Pacote;
import userinterface.controller.abaCancelarExcluirController;

// imports do javafx
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// outros imports
import java.util.ArrayList;


public class UIabaCancelarExcluir extends Application{
    /* definindo um método start que não fará nada,
       pois ao extender Application, há a exigência deste método
       apesar de não usarmos */
    public void start(Stage stage){}

    /* definindo um método start que recebe um Pacote, uma ArrayList<Pacote
       e um Stage. Este será o método start que usaremos */
    public void start(Stage stage, Pacote pacote, ArrayList<Pacote> lista, Stage fonte) throws Exception {

        // carregando o fxml com FXMLLoader
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/userinterface/fxml/abaCancelarExcluir.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        // configurando a janela de exibição
        stage.setTitle("Excluir Pacote - POO");
        stage.setResizable(false);
        stage.getIcons().add(new javafx.scene.image.Image("/imagens/icone/editarPacote_icone.png"));

        // configurando o Controller do fxml
        abaCancelarExcluirController controller = fxmlLoader.getController();
        controller.setPacote(pacote, lista, fonte);

        // tornando visível ao usuário
        stage.setScene(scene);
        stage.show();
    }
}
