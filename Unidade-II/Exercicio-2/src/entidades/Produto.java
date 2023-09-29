package entidades;
public class Produto {
    private String nome;
    private Double preco;

    public Produto(String nome, Double preco){
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String etiqueta(){
        return (this.nome+" R$ "+String.format("%.2f", this.preco));
    }
    
    @Override
    public String toString(){
        return etiqueta();
    }
}
