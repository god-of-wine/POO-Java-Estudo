package servicos;

public class ServicoPayPal implements ServicoPagamentoOnline{
    public Double taxaPagamento(Double montante){
        return (montante+(montante*2D/100D));
    }
    public Double juros(Double quantia, Integer meses){
        return (quantia+((quantia/100D)*meses));
    }
}
