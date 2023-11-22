package aplicacao;

import java.util.ArrayList;

import entidades.Pacote;
import fxmls.FXMLPainelEditarExcluirController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMLPainelEditarExcluir extends Application{
    public void start(Stage stage){}
    public void start(Stage stage, Pacote pacote, ArrayList<Pacote> lista, Stage fonte) throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxmls/painelEditarExcluir.fxml"));
        Parent root = fxmlLoader.load();

        FXMLPainelEditarExcluirController fxmlPEEController = fxmlLoader.getController();
        fxmlPEEController.setInfo(pacote.toString());
        fxmlPEEController.setPacote(pacote);
        fxmlPEEController.setLista(lista);
        fxmlPEEController.setStage(fonte);

        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}
