package servicos.frete_entrega;

// o frete expresso possui um frete mais caro, porém um tempo de entrega menor
public class FreteExpresso implements FretePrazo{
    public Double CalculaFrete(int altura, int largura, int comprimento, int peso, int distancia){
        if(distancia==0) return 10.0;
        int pesocubico = (altura*largura*comprimento)/6000;
        if(pesocubico > peso){
            return (pesocubico/2.0 * (distancia/100.0))*1.3;
        }
        else return (peso/2.0 * (distancia/100.0))*1.3;
    }

    public Double CalculaPrazo(int distancia){
        return (((distancia/80)/24)*2.0/3.0)+2;
    }
}
