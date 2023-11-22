package userinterface.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

public class abaInfoRastreioController implements Initializable {

    public void setInfo(String info){
        infoPacoteArea.setText(info);
    }
    
    @FXML
    private TextArea infoPacoteArea;

    @FXML
    private Pane painelAuxiliar;

    @Override
    public void initialize(URL url, ResourceBundle rb){
    }

}
