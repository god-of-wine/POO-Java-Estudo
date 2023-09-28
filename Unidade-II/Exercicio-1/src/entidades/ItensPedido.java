package entidades;

public class ItensPedido {
    private Integer quantidade;
    private Double preco;
    private Produto produto;

    public ItensPedido(Integer quantidade, Produto produto){
        this.quantidade = quantidade;
        this.preco = calcPreco(produto);
        this.produto = produto;
    }

    private Double calcPreco(Produto produto){
        return produto.getPreco()*this.quantidade;
    }

    public String toString(){
        return (this.produto.getNome()+", R$ "+String.format("%.2f", produto.getPreco())+", quantidade: "+this.quantidade+". Subtotal: R$ "+String.format("%.2f", this.preco));
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
