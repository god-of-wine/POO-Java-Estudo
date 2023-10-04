package aplicacao;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import entidades.*;

public class App {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        List<Contribuintes> lista = new ArrayList<>();

        System.out.printf("Digite o número de contribuintes: "); int cont = ler.nextInt();

        for(int i=1;i<=cont;i++){
            System.out.println("\nDados do contribuinte #"+i);
            System.out.printf("Pessoa física ou jurídica(f/j): "); char op = ler.next().charAt(0);
            while(op!='f' && op!='j'){
                System.out.printf("Opção Inválida!\nTente novamente: "); op = ler.next().charAt(0);
            } ler.nextLine();
            System.out.printf("Nome: "); String nome = ler.nextLine();
            System.out.printf("Renda anual: "); double renda = ler.nextDouble();

            switch (op){
                case 'f': System.out.printf("Despesas com saúde: "); double despesas = ler.nextDouble(); ler.nextLine();
                          lista.add(new ContribuinteFisico(nome, renda, despesas));
                          break;
                case 'j': System.out.printf("Número de empregados: "); int empregados = ler.nextInt(); ler.nextLine();
                          lista.add(new ContribuinteJuridico(nome, renda, empregados));
                          break;
            }
        }
        double imptotal=0;
        System.out.println("\nIMPOSTOS PAGOS:");
        for(Contribuintes aux: lista){
            System.out.println(aux);
            imptotal+=aux.getImposto();
        }
        System.out.println("IMPOSTOS TOTAIS: R$ "+String.format("%.2f", imptotal));
        ler.close();
    }
}
