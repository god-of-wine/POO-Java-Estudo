package aplicacao;

import entidades.Dados;

import java.util.Scanner;
import java.util.ArrayList;

public class App{
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);
        Dados pessoa = new Dados();
        String name, email;
        int quarto;
        ArrayList<Dados> pensionato = new ArrayList<Dados>();

        for(int i=0;i<10;i++) pensionato.add(null);

        System.out.printf("Quantos quartos serão alugados? ");
        int quantidade = ler.nextInt(); ler.nextLine();

        for(int i=1;i<=quantidade;i++){
            System.out.println("Aluguel #"+i);
            System.out.printf("Nome: "); name = ler.nextLine();
            System.out.printf("Email: "); email = ler.nextLine();
            System.out.printf("Quarto: "); quarto = ler.nextInt(); ler.nextLine();
            if(pensionato.get(quarto)!=null){System.out.println("Quarto já ocupado, tente outro!"); i--;}
            else{pessoa = new Dados(name, email, quarto); pensionato.add(quarto, pessoa);}
            System.out.println("");
        }

        System.out.println("Quartos ocupados:");
        for(int i=0; i < pensionato.size();i++){
            if(pensionato.get(i)!=null) System.out.println(pensionato.get(i));
        }

        ler.close();
    }
}