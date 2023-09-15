package aplicacao;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

import entidades.Alunos;
import servicos.OrdemAlfabetica;

public class App {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        ArrayList<Alunos> chamada = new ArrayList<>();
        int op;

        do {
            Collections.sort(chamada, new OrdemAlfabetica());
            System.out.printf("1- Cadastrar novo aluno.%n2- Verificar banco de dados.%n3- Fechar.%n");
            op = ler.nextInt(); ler.nextLine();
            switch (op){
                case 1: float vet[] = new float[3];
                        System.out.printf("Nome: "); String nome = ler.nextLine();
                        for(int i=0;i<3;i++) {System.out.printf("Nota "+(i+1)+": "); vet[i] = ler.nextFloat();}
                        chamada.add(new Alunos(nome, vet[0], vet[1], vet[2])); 
                        break;
                case 2: for (Alunos obj: chamada){System.out.println(obj);}
            }

        }while(op!=3);

        ler.close();
    }
}
