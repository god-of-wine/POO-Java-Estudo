package entidades;

import java.util.ArrayList;

public class Disciplina {
    private String codigo, nome;
    ArrayList<Alunos> Lista = new ArrayList<>();

    public Disciplina(String nome, String cod){
        this.nome = nome;
        this.codigo = cod;
        
    }

    public void addAluno(Alunos aluno){
        Lista.add(aluno);
    }

    private Alunos MelhorAluno(){
        Alunos melhor = null;
        for(Alunos aluno: Lista){
            if(aluno==Lista.get(0)){melhor = aluno;}
            else{
                if(aluno.getMedia()>melhor.getMedia()){melhor = aluno;}
            }
        }
        return melhor;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("\n-----------------------------------------------------\nCodigo: "+this.codigo+"\nMateria: "+this.nome).append("\n\nAlunos aprovados: \n");
        for(Alunos aluno : Lista){
            if(aluno.getMedia()>=7){ sb.append(aluno).append("\n"); }
        }
        sb.append("\nMelhor aluno: ").append(MelhorAluno()).append("\n----------------------------------------------------");

        return sb.toString();
    }

    //getters e setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Alunos> getLista() {
        return Lista;
    }

    public void setLista(ArrayList<Alunos> lista) {
        Lista = lista;
    }
}
