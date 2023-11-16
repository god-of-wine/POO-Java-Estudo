package fxmls;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import entidades.Pacote;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class FXMLRastrearPacoteController implements Initializable{
    private ArrayList<Pacote> listaBDD = new ArrayList<>();

    public void setListaBBD(ArrayList<Pacote> listaBBD) throws Exception{
        this.listaBDD = listaBBD;
        addPaineis();
    }
    
    @FXML
    private Button buscarBotao;

    @FXML
    private TextField buscarField;

    @FXML
    private ComboBox<?> filtrarComboBox;

    @FXML
    private ScrollPane scrollPainel;

    @FXML
    private void addPaineis() throws Exception{
        VBox conteudo = new VBox();
        for(Pacote pacote : listaBDD){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmls/painelauxiliarrastrear.fxml"));
            Parent root = loader.load();
            FXMLPainelAuxiliarRastreioController controller = loader.getController();
            controller.setInfo(pacote.toString());
            conteudo.getChildren().add(root);
        }
        scrollPainel.setContent(conteudo);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
    }
}
