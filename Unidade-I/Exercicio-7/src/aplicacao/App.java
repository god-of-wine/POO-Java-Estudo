package aplicacao;

import java.util.Scanner;

import entidades.Dados;

public class App{
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);
        Dados vet[] = new Dados[10];
        String name1, email;
        int quarto;

        System.out.printf("Quantos quartos serão alugados? ");
        int quantidade = ler.nextInt(); ler.nextLine();

        for(int i=1;i<=quantidade;i++){
            System.out.println("Aluguel #"+i);
            System.out.printf("Nome: "); name1 = ler.nextLine();
            System.out.printf("Email: "); email = ler.nextLine();
            System.out.printf("Quarto: "); quarto = ler.nextInt(); ler.nextLine();
            if(vet[quarto]!=null){ System.out.println("Quarto já ocupado, tente outro!"); i--;}
            else vet[quarto] = new Dados(name1, email, quarto);
            System.out.println("");
        }

        System.out.println("Quartos ocupados:");
        for(Dados obj: vet){
            if(obj!=null) System.out.println(obj);
        }

        ler.close();
    }
}