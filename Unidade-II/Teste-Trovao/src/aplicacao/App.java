package aplicacao;

import entidades.*;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class App {
    public static void main(String[] args) throws ParseException{
        Scanner ler = new Scanner(System.in);
        Biblioteca saraiva = new Biblioteca();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.printf("Informe o número de mídias: "); int qt = ler.nextInt();

        for(int i=1;i<=qt;i++){
            System.out.println("*** Dados da Mídia "+i+" ***");
            System.out.printf("Qual o tipo (1)Livro (2)Revista: "); int op = ler.nextInt(); ler.nextLine();
            System.out.printf("Informe o título: "); String titulo = ler.nextLine();
            System.out.printf("Informe o ano de publicação: "); int pub = ler.nextInt();

            switch(op){
                case 1: System.out.printf("Informe o ISBN: "); ler.nextLine(); String isbn = ler.nextLine();
                        System.out.printf("Informe o número de autores: "); int numaut = ler.nextInt(); ler.nextLine();
                        Livro livro = new Livro(titulo, pub, isbn);
                        for(int j=0;j<numaut;j++){
                            System.out.printf("Informe o nome do autor %d: ", (j+1)); String nome = ler.nextLine();
                            System.out.printf("Informe a data de nascimento: "); String data = ler.nextLine();
                            livro.addAutor(new Autor(nome, sdf.parse(data)));
                        }
                        saraiva.addItem(livro);
                        break;

                case 2: System.out.printf("Qual o número de edição da revista: "); int edi = ler.nextInt(); ler.nextLine();
                        saraiva.addItem(new Revista(titulo, pub, edi));
                        break;
            }
        }

        System.out.println("*** Acervo da Biblioteca ***");
        for(ItemDeMidia item : saraiva.getAcervo()){
            System.out.println(item+"----------");
        }

        System.out.printf("Qual o título a ser pesquisado: "); String nome = ler.nextLine();
        System.out.println(saraiva.pesquisarItem(nome));
        
        ler.close();
    }
}
