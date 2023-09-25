package aplicacao;

import java.util.Collections;
import java.util.Scanner;

import entidades.Disciplina;
import entidades.Alunos;

import servicos.ordenalfabeto;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner ler = new Scanner(System.in);
        System.out.printf("Informe o código da disciplina: "); String cod = ler.nextLine();
        System.out.printf("Informe o nome da disciplina: "); String nome = ler.nextLine();
        Disciplina aula = new Disciplina(nome, cod);

        System.out.printf("\nInforme o número de alunos: "); int qt = ler.nextInt(); System.out.println(""); ler.nextLine();

        for(int i=0 ; i<qt ; i++){
            System.out.println("\nInforme os Dados do Aluno "+(i+1)+":");
            System.out.printf("Matrícula: "); String matricula = ler.nextLine();
            System.out.printf("Nome: "); nome = ler.nextLine();
            System.out.printf("Nota 1: "); float nota1 = ler.nextFloat();
            System.out.printf("Nota 2: "); float nota2 = ler.nextFloat();
            System.out.printf("Nota 3: "); float nota3 = ler.nextFloat();
            ler.nextLine();
            aula.addAluno(new Alunos(matricula, nome, nota1, nota2, nota3));
        }

        Collections.sort(aula.getLista(), new ordenalfabeto());
        
        System.out.println(aula);
        ler.close();
    }
}
