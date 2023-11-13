package grafo;

public class Aresta {
    private Integer km;
    private Integer destino;

    public Aresta(Integer km, Integer destino){
        this.km = km;
        this.destino = destino;
    }

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }

    public Integer getDestino() {
        return destino;
    }

    public void setDestino(Integer destino) {
        this.destino = destino;
    }
}
