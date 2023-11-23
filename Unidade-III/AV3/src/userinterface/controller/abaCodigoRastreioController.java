package userinterface.controller;

// imports do javafx
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

// outros imports
import java.net.URL;
import java.util.ResourceBundle;

public class abaCodigoRastreioController implements Initializable{
    private String codigo;

    public void setCodigo(String codigo){
        this.codigo = codigo;
        rastreioField.setText(codigo);
    }

    public String getCodigo(){
        return codigo;
    }

    @FXML
    private Button okBotao;

    // esse método é chamado quando o botão é pressionado no fxml
    @FXML
    private void okBotaoAcao(ActionEvent event) throws Exception{
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private TextField rastreioField;

    @Override
    public void initialize(URL url, ResourceBundle rb){
    }
}
