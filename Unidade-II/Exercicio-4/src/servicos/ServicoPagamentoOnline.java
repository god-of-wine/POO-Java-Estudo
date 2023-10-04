package servicos;

public interface ServicoPagamentoOnline {
    public Double taxaPagamento(Double montante);
    public Double juros(Double quantia, Integer meses);
}
