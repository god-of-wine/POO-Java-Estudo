package servicos.frete_entrega;

public class FreteEconomico implements FretePrazo{
    public Double CalculaFrete(int altura, int largura, int comprimento, int peso, int distancia){
        if(distancia==0) return 10.0;
        int pesocubico = (altura*largura*comprimento)/6000;
        if(pesocubico > peso){
            return pesocubico/2.0 * (distancia/100.0);
        }
        else return peso/2.0 * (distancia/100.0);
    }

    public Double CalculaPrazo(int distancia){
        return ((distancia/80.0)/24.0)+2;
    }
}
