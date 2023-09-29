package entidades;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoUsado extends Produto {
    private Date fabrica;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public ProdutoUsado(String nome, Double preco, Date fabrica){
        super(nome, preco);
        this.fabrica = fabrica;
    }

    public Date getFabrica() {
        return fabrica;
    }

    public void setFabrica(Date fabrica) {
        this.fabrica = fabrica;
    }

    public String etiqueta(){
        return (getNome()+" (usado) R$ "+String.format("%.2f", getPreco())+" (Data de Fabricação: "+sdf.format(this.fabrica)+")");
    }
}
