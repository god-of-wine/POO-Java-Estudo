package servicos;

import entidades.*;

import java.util.Calendar;

public class ServicoContrato {
    private ServicoPagamentoOnline SPO;
    Calendar calendario = Calendar.getInstance();

    public void processarContrato(Contrato contrato, Integer meses, ServicoPagamentoOnline SPO){
        calendario.setTime(contrato.getData());

        for(int i=1;i<=meses;i++){
            calendario.add(Calendar.MONTH, 1);
            contrato.addParcela(new Parcela(calendario.getTime(), SPO.taxaPagamento(SPO.juros(contrato.getValorTotal()/meses, i))));
        }
    }

    public ServicoPagamentoOnline getSPO() {
        return SPO;
    }

    public void setSPO(ServicoPagamentoOnline sPO) {
        SPO = sPO;
    }
}
