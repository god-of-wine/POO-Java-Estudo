package aplicacao;
import java.util.Scanner;

import entidades.Produto;
import entidades.ProdutoImportado;
import entidades.ProdutoUsado;

import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App {
    public static void main(String[] args) throws ParseException{
        Scanner ler = new Scanner(System.in);
        List<Produto> lista = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.printf("Digite o número de produtos: "); int qt = ler.nextInt(); ler.nextLine(); System.out.printf("\n");

        for(int i=1;i<=qt;i++){
            System.out.printf("\nDados do produto #"+i+"\nComum, usado ou importado (c/u/i): "); char op = ler.next().charAt(0); ler.nextLine();
            switch (op){
                case 'c': System.out.printf("Nome: "); String nome = ler.nextLine();
                          System.out.printf("Preço: "); double preco = ler.nextDouble(); ler.nextLine();
                          lista.add(new Produto(nome, preco));
                          break;
                case 'i': System.out.printf("Nome: "); nome = ler.nextLine();
                          System.out.printf("Preço: "); preco = ler.nextDouble();
                          System.out.printf("Taxa Alfandegária: "); double taxa = ler.nextDouble(); ler.nextLine();
                          lista.add(new ProdutoImportado(nome, preco, taxa));
                          break;
                case 'u': System.out.printf("Nome: "); nome = ler.nextLine();
                          System.out.printf("Preço: "); preco = ler.nextDouble(); ler.nextLine();
                          System.out.printf("Data de Fabricação (DD/MM/AAAA): "); String data = ler.nextLine(); Date date = sdf.parse(data);
                          lista.add(new ProdutoUsado(nome, preco, date));
                          break;
            }
        }
        System.out.println("\nETIQUETAS DE PREÇO:");
        for(Produto aux:lista){
            System.out.println(aux);
        }

        ler.close();
    }
}
