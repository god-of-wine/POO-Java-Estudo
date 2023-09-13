import java.util.Scanner;

import entidades.Contabancaria;

public class App {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.printf("Informe o número da conta: "); int id = ler.nextInt(); ler.nextLine();
        System.out.printf("Informe o nome do tituar da conta: "); String nome = ler.nextLine();
        System.out.printf("Haverá um depósito inicial?: "); char op = ler.next().charAt(0);

        Contabancaria pessoa;

        if(op=='n' || op=='N') pessoa = new Contabancaria(id, nome);
        else {
            System.out.printf("Informe o valor do deposito inicial: "); float saldo = ler.nextFloat();
            pessoa = new Contabancaria(id, nome, saldo);
        }

        System.out.println("Dados da conta:");
        System.out.println(pessoa);

        System.out.printf("Informe o valor de depósito: "); pessoa.addSaldo(ler.nextFloat());
        System.out.println("Dados da conta:");
        System.out.println(pessoa);

        System.out.printf("Informe o valor de saque: "); pessoa.remSaldo(ler.nextFloat());
        System.out.println("Dados da conta:");
        System.out.println(pessoa);

        ler.close();

    }
}
