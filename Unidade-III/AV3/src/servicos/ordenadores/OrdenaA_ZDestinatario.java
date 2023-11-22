package servicos.ordenadores;

import java.util.Comparator;

import entidades.pacote.Pacote;

public class OrdenaA_ZDestinatario implements Comparator<Pacote>{
    public int compare(Pacote p1, Pacote p2){
        return p1.getNome_destinatario().compareTo(p2.getNome_destinatario());
    }
}