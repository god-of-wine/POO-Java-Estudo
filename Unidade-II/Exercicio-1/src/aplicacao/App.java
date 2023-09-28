package aplicacao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;

import entidades.Cliente;
import entidades.ItensPedido;
import entidades.Pedido;
import entidades.Produto;
import servicos.StatusPedido;

public class App {
    public static void main(String[] args) throws ParseException{
        Scanner ler = new Scanner(System.in);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Informe os dados do Cliente:");
        System.out.printf("Nome: "); String nome = ler.nextLine();
        System.out.printf("E-mail: "); String email = ler.nextLine();
        System.out.printf("Data de Nascimento (DD/MM/YYYY): "); String data = ler.nextLine(); Date date = formatter.parse(data);
        Cliente cliente = new Cliente(nome, email, date);

        System.out.println("\nInforme os dados do Pedido:");
        System.out.printf("Status: "); nome = ler.next().toUpperCase();
        System.out.printf("Quantos itens para este pedido: "); int qt = ler.nextInt(); ler.nextLine();
        Date agora = new Date();
        Pedido pedido = new Pedido(agora, StatusPedido.valueOf(nome), cliente);

        for(int i=1;i<=qt;i++){
            System.out.println("\n\nInforme os dados do item "+i+":");
            System.out.printf("Nome do produto: "); nome = ler.nextLine();
            System.out.printf("Preço do produto: "); Double preco = ler.nextDouble();
            System.out.printf("Quantidade: "); int quant = ler.nextInt(); ler.nextLine();
            pedido.addItem(new ItensPedido(quant, new Produto(nome, preco)));
        }

        System.out.println(pedido);
        ler.close();
    }
}
