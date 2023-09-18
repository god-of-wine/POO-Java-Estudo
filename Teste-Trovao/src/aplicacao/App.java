package aplicacao;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

import entidades.Comentarios;
import entidades.Postagens;

public class App {
    public static void main(String[] args) throws ParseException {
        List<Postagens> rede = new ArrayList<>();
        Scanner ler = new Scanner(System.in);
        Integer op;

        do {
            Menu();
            op = ler.nextInt();

            switch (op){
                case 1: Visuzalizar(rede); break;
                case 2: rede.add(Comentar()); break;
            }

        }while(op!=3);
        
        ler.close();
    }

    public static void Menu(){
        System.out.println("1 - Ver Postagens\n2 - Adicionar Postagens\n3 - Sair");
    }

    public static void subMenu(){
        System.out.println("1 - Comentar\n2 - Curtir\n3 - Voltar\n'p' proximo - 'a' anterior");
    }

    public static void Visuzalizar(List<Postagens> rede){
        Scanner ler = new Scanner(System.in);
        int op;
        do{
            subMenu();
            op = ler.nextInt();
            
        }while(op!=3);
    }
    
    public static Postagens Comentar(){
        Scanner ler = new Scanner(System.in);
        System.out.printf("Título: "); String titulo = ler.nextLine();
        System.out.printf("Conteúdo: "); String conteudo = ler.nextLine();
        Date dataAtual = new Date();
        Postagens post = new Postagens(dataAtual, titulo, conteudo);
        return post;
    }
}
