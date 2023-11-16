package fxmls;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

public class FXMLPainelAuxiliarRastreioController implements Initializable{
    private String info;

    public void setInfo(String info){
        this.info=info;
        infoPacoteArea.setText(info);
    }

    public String getInfo(){
        return info;
    }
    
    @FXML
    private TextArea infoPacoteArea;

    @FXML
    private Pane painelAuxiliar;

    @Override
    public void initialize(URL url, ResourceBundle rb){
    }

}
