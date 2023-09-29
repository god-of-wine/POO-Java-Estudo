package entidades;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import servicos.StatusPedido;

public class Pedido {
    private Date momento;
    private StatusPedido status;
    private Cliente cliente;
    private List<ItensPedido> itens = new ArrayList<>();

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public Pedido(Date momento, StatusPedido status, Cliente cliente){
        this.momento = momento;
        this.status = status;
        this.cliente = cliente;
    }

    public void addItem(ItensPedido item){
        itens.add(item);
    }

    public void removeItem(ItensPedido item){
        itens.remove(item);
    }

    public Double calcTotal(){
        Double soma=0d;
        for(ItensPedido pro:itens){
            soma+=pro.getPreco();   
        }
        return soma;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nRESUMO DO PEDIDO:\nMomento do pedido: ").append(sdf.format(this.momento))
        .append("\nStatus do pedido: ").append(this.status)
        .append("\nCliente: ").append(this.cliente).append("\n")

        .append("\nItens do pedido:\n");
        for(ItensPedido aux:itens) sb.append(aux).append("\n");
        sb.append("Valor total: R$ ").append(String.format("%.2f", calcTotal()));
        return sb.toString();
    }

    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public List<ItensPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItensPedido> itens) {
        this.itens = itens;
    }
}
