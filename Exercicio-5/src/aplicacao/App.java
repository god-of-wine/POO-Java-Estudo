package aplicacao;

import java.util.Scanner;

import entidades.ConversorMoeda;

public class App {
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);
        ConversorMoeda conversor = new ConversorMoeda();

        System.out.printf("Qual é o preço do dólar? "); float dolar = ler.nextFloat();
        System.out.printf("Quantos dólares serão comprados? "); float quantidade = ler.nextFloat();
        System.out.printf("Valor a ser pago em reais = "+String.format("%.2f", conversor.cotacao(dolar, quantidade)));

        ler.close();
    }
}
