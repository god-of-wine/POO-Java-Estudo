package aplicacao;

import java.util.ArrayList;

import entidades.Pacote;
import fxmls.FXMLCancelarExcluirController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMLCancelarExcluir extends Application{
    public void start(Stage stage){}
    public void start(Stage stage, Pacote pacote, ArrayList<Pacote> lista, Stage fonte) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxmls/cancelar_excluir.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        stage.setTitle("Excluir Pacote - POO");
        stage.setResizable(false);
        stage.getIcons().add(new javafx.scene.image.Image("/imagens/editarPacote_icone.png"));

        FXMLCancelarExcluirController controller = fxmlLoader.getController();
        controller.setPacote(pacote, lista, fonte);

        stage.setScene(scene);
        stage.show();
    }
}
