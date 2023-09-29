package entidades;
public class ProdutoImportado extends Produto{
    private Double taxa;

    public ProdutoImportado(String nome, Double preco, Double taxa){
        super(nome, preco);
        this.taxa = taxa;
    }

    public Double getTaxa() {
        return taxa;
    }

    public void setTaxa(Double taxa) {
        this.taxa = taxa;
    }

    public String etiqueta(){
        return (getNome()+" R$ "+String.format("%.2f", getPreco()+this.taxa)+" (Taxa alfandegária: R$ "+String.format("%.2f", this.taxa)+")");
    }

    @Override
    public String toString(){
        return etiqueta();
    }
}