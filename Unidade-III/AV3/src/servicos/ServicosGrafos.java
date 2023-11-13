package servicos;

import grafo.*;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ServicosGrafos {
    public void IniciaGrafoBrasil(Grafo grafo){
        int[][] arestas = { {0, 8, 416},{1, 2, 501}, {1, 8, 408}, {2, 0, 444}, {3, 1, 664}, {3, 2, 441}, {4, 2, 1632}, {4, 3, 1349}, 
            {5, 4, 806}, {6, 4, 1183}, {6, 5, 779}, {7, 1, 1083}, {7, 3, 740}, {7, 4, 1444}, {7, 6, 2021}, {8, 0, 416}, {9, 8, 701} };

        for(int[] aresta : arestas){
            grafo.addAresta(aresta[0], aresta[1], aresta[2]);
        }
    }

    public int Dijkstra(Grafo grafo, int origem, int destino){
        int[] dist = new int[grafo.getSedes()];
        int[] pai = new int[grafo.getSedes()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[origem] = 0;

        PriorityQueue<Integer> fila = new PriorityQueue<>(grafo.getSedes(), (a, b) -> dist[a] - dist[b]);
        fila.add(origem);

        while(!fila.isEmpty()) {
            int u = fila.poll();

            for(Aresta aresta : grafo.getAdjacencia().get(u)){
                int v = aresta.getDestino();
                int distancia = aresta.getKm();

                if(dist[u] != Integer.MAX_VALUE && dist[u] + distancia < dist[v]){
                    dist[v] = dist[u]+distancia;
                    pai[v]=u;
                    fila.add(v);
                }
            }
        }
        return dist[destino];
    }
}
