package aplicacao.fxml;

// imports de arquivos locais
import entidades.pacote.Pacote;
import userinterface.controller.abaEditarExcluirController;

// imports do javafx
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// outros imports
import java.util.ArrayList;

public class UIabaEditarExcluir extends Application{
    /* definindo um método start que não fará nada,
       pois ao extender Application, há a exigência deste método
       apesar de não usarmos */
    public void start(Stage stage){}

    /* definindo um método start que recebe um Pacote, uma ArrayList<Pacote>
       e um Stage. Este será o método start que usaremos */
    public void start(Stage stage, Pacote pacote, ArrayList<Pacote> lista, Stage fonte) throws Exception{

        // carregando o fxml com FXMLLoader
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/userinterface/fxml/abaEditarExcluir.fxml"));
        Parent root = fxmlLoader.load();

        // configurando o Controller do fxml
        abaEditarExcluirController fxmlPEEController = fxmlLoader.getController();
        fxmlPEEController.setInfo(pacote.toString());
        fxmlPEEController.setPacote(pacote);
        fxmlPEEController.setLista(lista);
        fxmlPEEController.setStage(fonte);

        // tornando visível ao usuário
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}
