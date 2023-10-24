package aplicacao;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import entidades.*;

public class App {
    public static void main(String[] args) throws ParseException{
        Scanner input = new Scanner(System.in);
        ArrayList<Funcionario> folha = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.printf("Informe o número de funcionários: "); int qt = input.nextInt(); input.nextLine();
        System.out.println("*** Informe os dados dos funcionários ***");
        for(int i=0;i<qt;i++){
            System.out.printf("Nome: "); String nome = input.nextLine();
            System.out.printf("Número Funcional: "); int id = input.nextInt(); input.nextLine();
            System.out.printf("Data de Admissão (DD/MM/YYYY): "); String data = input.nextLine(); Date admissao = sdf.parse(data);
            System.out.printf("Informe o tipo (1)Efetivo (2)Estagiário (3)Temporário: "); int op = input.nextInt();
            switch (op){
                case 1: System.out.printf("Informe o salário mensal: "); Double salario = input.nextDouble(); input.nextLine();
                        folha.add(new Efetivo(nome, id, admissao, salario));
                        break;
                case 2: System.out.printf("Informe o valor da bolsa: "); Double bolsa = input.nextDouble(); input.nextLine();
                        System.out.printf("Informe o nome da universidade: "); String uni = input.nextLine();
                        folha.add(new Estagiario(nome, id, admissao, bolsa, uni));
                        break;
                case 3: System.out.printf("Informe o valor do salário hora: "); Double salHora = input.nextDouble();
                        System.out.printf("Informe o número de hora: "); int hora = input.nextInt(); input.nextLine();
                        folha.add(new Temporario(nome, id, admissao, salHora, hora));
                        break;
                default: System.out.println("Opção inválida, tente novamente!\n");
                         i--;
                         break;
            }
            System.out.println("-------------------------");
        }
        System.out.println("*** Dados da Folha ***");
        Double valortotal=0D;

        for(Funcionario item : folha){
            System.out.println(item);
            valortotal+=item.calcularSalario();
        }
        System.out.println("Valor total da folha = "+String.format("%.2f", valortotal));
        input.close();
    }
}
