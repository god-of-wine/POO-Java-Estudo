package aplicacao;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.printf("Nome: "); String nome = ler.nextLine();
        System.out.printf("Salário Bruto: "); float salb = ler.nextFloat();
        System.out.printf("Imposto: "); float imposto = ler.nextFloat();

        System.out.println("\nEmpregado "+nome+String.format(", R$ %.2f", (salb-imposto)));

        System.out.printf("Porcentagem de aumento: "); float porcet = ler.nextFloat();

        salb=AjustaSalario(salb, porcet);

        System.out.println("\nDados atualizados\nEmpregado "+nome+String.format(", R$ %.2f", (salb-imposto)));

        ler.close();
        
    }
    public static float AjustaSalario(float salario, float porcentagem){
        return salario+salario*porcentagem/100;   }
}
