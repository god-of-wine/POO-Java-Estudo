package userinterface.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import entidades.pacote.Pacote;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import servicos.ordenadores.OrdenaA_ZDestinatario;
import servicos.ordenadores.OrdenaA_ZRemetente;
import servicos.ordenadores.OrdenaEntrega;

public class menuRastrearPacoteController implements Initializable{
    private ArrayList<Pacote> listaBDD = new ArrayList<>();

    public void setListaBBD(ArrayList<Pacote> listaBBD) throws Exception{
        this.listaBDD = listaBBD;
        addPaineis();
    }
    
    @FXML
    private Button buscarBotao;

    @FXML
    private void buscarBotaoAcao(ActionEvent e){
        String busca = buscarField.getText();
        List<Pacote> listaBBDFiltrada;
        if(busca.length()==14){ listaBBDFiltrada = listaBDD.stream().filter(pacote -> pacote.getCpf_destinatario().contains(busca)).collect(Collectors.toList());
        } else {
            if(busca.length()==13){ listaBBDFiltrada = listaBDD.stream().filter(pacote -> pacote.getCodigo().contains(busca)).collect(Collectors.toList());
            } else {
                listaBBDFiltrada = listaBDD;
            }
        }
        ordenaComboBox(listaBBDFiltrada);
        updateUI(listaBBDFiltrada);
    }

    @FXML
    private TextField buscarField;

    @FXML
    private ComboBox<String> filtrarComboBox;

    private void loadComboBox(){
        List<String> opcoes = new ArrayList<>();
        opcoes.add("A - Z Remetente");
        opcoes.add("A - Z Destinatario");
        opcoes.add("Data de entrega");

        filtrarComboBox.setItems(FXCollections.observableArrayList(opcoes));
    }

    private void ordenaComboBox(List<Pacote> listaBBDFiltrada){
        if(filtrarComboBox.getSelectionModel().getSelectedItem()=="A - Z Remetente"){
            Collections.sort(listaBBDFiltrada, new OrdenaA_ZRemetente());
        }
        if(filtrarComboBox.getSelectionModel().getSelectedItem()=="A - Z Destinatario"){
            Collections.sort(listaBBDFiltrada, new OrdenaA_ZDestinatario());
        }
        if(filtrarComboBox.getSelectionModel().getSelectedItem()=="Data de entrega"){
            Collections.sort(listaBBDFiltrada, new OrdenaEntrega());
        }
    }

    private void ordenaComboBox(){
        filtrarComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            
            String busca = buscarField.getText();
            List<Pacote> listaBBDFiltrada;
            if(busca.length()==14){ listaBBDFiltrada = listaBDD.stream().filter(pacote -> pacote.getCpf_destinatario().contains(busca)).collect(Collectors.toList());
            } else {
            if(busca.length()==13){ listaBBDFiltrada = listaBDD.stream().filter(pacote -> pacote.getCodigo().contains(busca)).collect(Collectors.toList());
            } else {
                listaBBDFiltrada = listaBDD;
            }
        }

            ordenaComboBox(listaBBDFiltrada);
            updateUI(listaBBDFiltrada);
        });
    }

    @FXML
    private ScrollPane scrollPainel;

    @FXML
    private void addPaineis() throws Exception{
        VBox conteudo = new VBox();
        for(Pacote pacote : listaBDD){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/userinterface/fxml/abaInfoRastreio.fxml"));
            Parent root = loader.load();
            abaInfoRastreioController controller = loader.getController();
            controller.setInfo(pacote.toString());
            conteudo.getChildren().add(root);
        }
        scrollPainel.setContent(conteudo);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        loadComboBox();
        ordenaComboBox();
    }

    public void updateUI(List<Pacote> lista){
        try {
            ((VBox) scrollPainel.getContent()).getChildren().clear();
            for(Pacote pacote : lista){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/userinterface/fxml/abaInfoRastreio.fxml"));
                Parent root = loader.load();
                abaInfoRastreioController controller = loader.getController();
                controller.setInfo(pacote.toString());
                ((VBox) scrollPainel.getContent()).getChildren().add(root);
            }
        } catch (Exception e){

        }
    }
}
