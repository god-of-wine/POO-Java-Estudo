package servicos;

import java.util.Comparator;

import entidades.Funcionario;

public class ordenaids implements Comparator<Funcionario>{
    public int compare(Funcionario o1, Funcionario o2){
        if(o1.getId() < o2.getId()){
            return -1;
        }
        else{
            if(o1.getId() > o2.getId()){
                return 1;
            }
            else return 0;
        }
    }
}
