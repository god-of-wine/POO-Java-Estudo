package servicos;

public class FreteEconomico implements FretePrazo{
    public Double CalculaFrete(int altura, int largura, int comprimento, int peso, int distancia){
        if(distancia==0) return 10.0;
        int pesocubico = (altura*largura*comprimento)/6000;
        if(pesocubico > peso){
            return pesocubico * (distancia/100.0);
        }
        else return peso * (distancia/100.0);
    }

    public Double CalculaPrazo(int distancia){
        return Math.ceil((distancia/80.0)/24.0);
    }
}
