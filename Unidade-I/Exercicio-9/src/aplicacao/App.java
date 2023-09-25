package aplicacao;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

import entidades.Funcionario;
import servicos.ordenaids;

public class App {
    public static void main(String[] args){
        float salario;
        Scanner ler = new Scanner(System.in);
        ArrayList<Funcionario> lista = new ArrayList<>();

        System.out.printf("Quantos empregados serão cadastrados: "); int qt = ler.nextInt();
        for(int i=1 ; i<=qt ; i++){
            System.out.println("Empregado #"+i);
            System.out.printf("ID: "); int id=ler.nextInt(); ler.nextLine();
            System.out.printf("Nome: "); String nome = ler.nextLine();
            System.out.printf("Salario: "); salario = ler.nextFloat();
            System.out.println();

            lista.add(new Funcionario(id, nome, salario));
        }

        Collections.sort(lista, new ordenaids());

        System.out.printf("Informe o Id do funcionário que terá seu salário modificado: "); qt = ler.nextInt();
        
        boolean encontrado = false;
        for(Funcionario obj: lista){
            if (obj.getId()==qt){
                System.out.printf("Informe o percentual: "); salario = ler.nextFloat();
                obj.setAumento(salario);
                encontrado = true;
                break;
            }
        }
        if(!encontrado) System.out.println("Funcionario não encontrado!");
        System.out.println("%nLista de empregados:");

        for(Object obj: lista) System.out.println(obj);

        ler.close();
    }
}
