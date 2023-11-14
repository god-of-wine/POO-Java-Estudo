package aplicacao;

import javafx.application.Application;
import javafx.stage.*;

public class Programa extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLMenuPrincipal menuPrincipal = new FXMLMenuPrincipal();
        menuPrincipal.start(stage);
    }
}
