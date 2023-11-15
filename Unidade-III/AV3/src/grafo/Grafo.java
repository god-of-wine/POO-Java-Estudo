package grafo;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
    private Integer sedes;
    private List<List<Aresta>> adjacencia;

    // Construtor do grafo que cria um grafo com um numero X de Vértices
    public Grafo(Integer sedes){
        this.sedes = sedes;
        adjacencia = new ArrayList<>(sedes);
        for(int i=0; i<sedes; i++){
            adjacencia.add(new ArrayList<>());
        }
    }

    // Função que adiciona uma aresta que pode ir e voltar no grafo
    public void addAresta(Integer origem, Integer destino, Integer kilometros){
        adjacencia.get(origem).add(new Aresta(kilometros, destino));
        adjacencia.get(destino).add(new Aresta(kilometros, origem));
    }

    public Integer getSedes() {
        return sedes;
    }

    public void setSedes(Integer sedes) {
        this.sedes = sedes;
    }

    public List<List<Aresta>> getAdjacencia() {
        return adjacencia;
    }

    public void setAdjacencia(List<List<Aresta>> adjacencia) {
        this.adjacencia = adjacencia;
    }
}
