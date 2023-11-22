package servicos.frete_entrega;

public interface FretePrazo {
    public Double CalculaFrete(int altura, int largura, int comprimento, int peso, int distancia);
    public Double CalculaPrazo(int distancia);
}
