package servicos;

import java.util.Comparator;

import entidades.Alunos;

public class ordenalfabeto implements Comparator<Alunos>{
    public int compare(Alunos o1, Alunos o2){
        return o1.getNome().compareTo(o2.getNome());
    }
}
