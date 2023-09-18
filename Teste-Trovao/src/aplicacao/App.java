package aplicacao;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import entidades.Comentarios;
import entidades.Postagens;

public class App {
    public static void main(String[] args) throws ParseException {
        List<Postagens> rede = new ArrayList<>();
        Scanner ler = new Scanner(System.in);
        Integer op;

        do {
            Menu();
            op = ler.nextInt(); ler.nextLine();

            switch (op){
                case 1: if(rede.size()!=0) Visuzalizar(rede, ler); 
                        else System.out.println("Não há postagens, ainda.");
                        break;
                case 2: rede.add(Postar(ler)); 
                        break;
            }

        }while(op!=3);
        
        ler.close();
    }

    public static void Menu(){
        System.out.println("1 - Ver Postagens\n2 - Adicionar Postagens\n3 - Sair");
    }

    public static void subMenu(){
        System.out.println("1 - Comentar\n2 - Curtir\n3 - Voltar\n'p' proximo - 'a' anterior\n");
    }

    public static void Visuzalizar(List<Postagens> rede, Scanner ler){
        char op='0';
        for(int i=0;op!='3';){
            subMenu();
            System.out.println(rede.get(i));
            op = ler.next().charAt(0);
            switch (op){
                case 'a': if(i!=0){i--;} break;
                case 'p': if(i!=rede.size()-1){i++;} break;
                case '1': rede.get(i).addComentario(Comentar(ler)); break;
                case '2': rede.get(i).Curtir(); break;
            }
        }
    }
    
    public static Comentarios Comentar(Scanner ler){
        System.out.printf("Comentário: "); String comentario = ler.nextLine();
        return new Comentarios(comentario);
    }
    public static Postagens Postar(Scanner ler){
        System.out.printf("Título: "); String titulo = ler.nextLine();
        System.out.printf("Conteúdo: "); String conteudo = ler.nextLine();
        Date dataAtual = new Date();
        Postagens post = new Postagens(dataAtual, titulo, conteudo);
        return post;
    }
}
