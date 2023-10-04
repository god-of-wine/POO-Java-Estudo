package entidades;

import java.util.Date;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

public class Contrato {
    private Integer numero;
    private Date data;
    private Double valorTotal;
    private ArrayList<Parcela> parcelas = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Contrato(Integer numero, Date data, Double valorTotal){
        this.numero = numero;
        this.data = data;
        this.valorTotal = valorTotal;
    }

    public void addParcela(Parcela parcela){
        parcelas.add(parcela);
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public ArrayList<Parcela> getParcelas() {
        return parcelas;
    }

    public void setParcelas(ArrayList<Parcela> parcelas) {
        this.parcelas = parcelas;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Parcela parcela: parcelas) sb.append(sdf.format(parcela.getData())).append(" - R$").append(parcela.getValor()).append("\n");
        return sb.toString();
    }
}
