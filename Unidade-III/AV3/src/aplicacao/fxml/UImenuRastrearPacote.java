package aplicacao.fxml;

// imports de arquivos locais
import userinterface.controller.menuRastrearPacoteController;
import entidades.pacote.Pacote;

// imports do javafx
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// outros imports
import java.util.ArrayList;

public class UImenuRastrearPacote extends Application{
    /* definindo um método start que não fará nada,
       pois ao extender Application, há a exigência deste método
       apesar de não usarmos */
    public void start(Stage stage){}

    /* definindo um método start que recebe um Pacote e 
       uma ArrayList<Pacote>. Este será o método start que usaremos */
    public void start(Stage stage, ArrayList<Pacote> lista) throws Exception {

        // carregando o fxml com FXMLLoader
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/userinterface/fxml/menuRastrearPacote.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        // configurando a janela de exibição
        stage.setTitle("Rastrear Pacotes - POO");
        stage.setResizable(false);
        stage.getIcons().add(new javafx.scene.image.Image("/imagens/icone/editarPacote_icone.png"));

        // configurando o Controller do fxml
        menuRastrearPacoteController fxmlRPC = fxmlLoader.getController();
        fxmlRPC.setListaBBD(lista);

        // tornando visível ao usuário
        stage.setScene(scene);
        stage.show();
    }
}
