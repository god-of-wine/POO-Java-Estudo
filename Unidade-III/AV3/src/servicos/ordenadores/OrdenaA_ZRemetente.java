package servicos.ordenadores;

import java.util.Comparator;

import entidades.Pacote;

public class OrdenaA_ZRemetente implements Comparator<Pacote>{
    public int compare(Pacote p1, Pacote p2){
        return p1.getNome_remetente().compareTo(p2.getNome_remetente());
    }
}
