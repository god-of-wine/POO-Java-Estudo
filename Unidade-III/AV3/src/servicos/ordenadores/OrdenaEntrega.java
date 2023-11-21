package servicos.ordenadores;

import java.util.Comparator;

import entidades.Pacote;

public class OrdenaEntrega implements Comparator<Pacote>{
    public int compare(Pacote p1, Pacote p2){
        return p1.getData_entrega().compareTo(p2.getData_entrega());
    }
}
