package aplicacao;

import entidades.*;

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class App {
    public static void main(String[] args) throws ParseException{
        Scanner ler = new Scanner(System.in);
        Biblioteca saraiva = new Biblioteca();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        int op=0;

        do {
            System.out.printf("Bem vindo(a) à Saraiva!\n\n1 - Adicionar um Livro/Revista\n2 - Remover um Livro/Revista\n3 - Pesquisar um Livro/Revista\n0 - Sair\n\nOpção: ");
            op = ler.nextInt(); ler.nextLine();
            switch (op){
                case 1: System.out.printf("\n---- Adicionar novo Livro/Revista ----\n\nLivro ou Revista?: "); char LR = ler.next().charAt(0); ler.nextLine();
                        if(LR!='R'&&LR!='r'&&LR!='L'&&LR!='l'){
                            System.out.printf("Opção inválida!\n"); break;
                        }
                        System.out.printf("Título: "); String titulo = ler.nextLine();
                        System.out.printf("Ano de lançamento (yyyy): "); int ano = ler.nextInt();
                        if(LR=='l' || LR=='L'){
                            System.out.printf("ISBN: "); ler.nextLine(); String ISBN = ler.nextLine();
                            System.out.printf("Nome do autor: "); String nome = ler.nextLine();
                            System.out.printf("Nascimento do autor: "); String nascimento = ler.nextLine(); Date data = sdf.parse(nascimento);
                            saraiva.addItem(new Livro(titulo, ano, ISBN, new Autor(nome, data)));
                        }
                        if(LR=='R' || LR=='r'){
                            System.out.printf("Edição: "); int edicao = ler.nextInt();
                            saraiva.addItem(new Revista(titulo, ano, edicao));
                        }
                        break;

                case 2: System.out.printf("\n---- Remover um Livro/Revista ----\n\nDigite o título que deseja remover: "); titulo = ler.nextLine();
                        for(ItemDeMidia item : saraiva.getNaruto()){
                            if(titulo.equals(item.getTitulo())){ 
                                saraiva.remItem(item); break;
                            }
                        }
                        break;

                case 3: System.out.printf("\n---- Pesquisar por Títulos ----\n\nPesquisar por Título ou Autor?: "); LR = ler.next().charAt(0);
                        if(LR=='T' || LR=='t'){
                            System.out.printf("Digite o título que deseja buscar: "); ler.nextLine(); titulo = ler.nextLine();
                            System.out.println("Título(s) encontrado(s):");
                            for(ItemDeMidia item : saraiva.getNaruto()){
                                if(item.pesquisar(titulo)){
                                    System.out.println("- "+item.getTitulo());
                                }
                            }
                        }
                        if(LR=='A' || LR=='a'){
                            System.out.printf("Digite o autor que deseja buscar: "); ler.nextLine(); titulo = ler.nextLine();
                            System.out.println("Título(s) encontrado(s):");
                            for(ItemDeMidia item : saraiva.getNaruto()){
                                if(item instanceof Livro){
                                    if(((Livro)item).getAutor().pesquisar(titulo))
                                        System.out.println("- "+item.getTitulo());
                                }
                            }
                        }
                        break;
            }
        }while(op!=0);
        ler.close();
    }
}
