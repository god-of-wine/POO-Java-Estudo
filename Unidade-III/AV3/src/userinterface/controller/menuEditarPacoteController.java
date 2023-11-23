package userinterface.controller;

// imports de arquivos locais
import entidades.pacote.Pacote;

// imports do javafx
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

// outros imports
import java.util.ArrayList;

public class menuEditarPacoteController {
    private ArrayList<Pacote> listaBDD = new ArrayList<>();
    private Stage fonte;

    public void setListaBBD(ArrayList<Pacote> listaBBD, Stage fonte) throws Exception{
        this.listaBDD = listaBBD;
        this.fonte = fonte;
        addPaineis();
    }

    @FXML
    private GridPane gridPanel;

    @FXML
    private ScrollPane scrollPanel;

    /* Esse método adiciona os paineis na janela,
       sendo que cada painel é um novo fxml com
       informações distintas */
    @FXML
    private void addPaineis() throws Exception{
        gridPanel.getChildren().clear();
        gridPanel.setVgap(178);
        int coluna = 0, linha = 0;
        for(Pacote pacote : listaBDD){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/userinterface/fxml/abaEditarExcluir.fxml"));
            Parent root = loader.load();
            abaEditarExcluirController controller = loader.getController();
            controller.setInfo(pacote.toString());
            controller.setPacote(pacote);
            controller.setLista(listaBDD);
            controller.setStage(fonte);
            if(coluna==2){
                coluna=0;
                linha++;
            }
            gridPanel.add(root, coluna++, linha);
            GridPane.setMargin(root, new Insets(10));
        }
        gridPanel.add(new Pane(), gridPanel.getColumnCount(), gridPanel.getRowCount());
    }
}
