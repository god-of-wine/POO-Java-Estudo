package aplicacao;

import entidades.*;
import servicos.*;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App {
    public static void main(String[] args) throws ParseException{
        Scanner scanf = new Scanner(System.in);

        System.out.printf("Entre com os dados do contrato:\nNúmero: "); int num = scanf.nextInt(); scanf.nextLine();
        System.out.printf("Data: "); String data = scanf.nextLine();
        // transformando string em data
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = sdf.parse(data);
        //
        System.out.printf("Valor do contrato: "); double valor = scanf.nextDouble();
        System.out.printf("Entre com o número de parcelas: "); int parcelas = scanf.nextInt();

        Contrato jorge = new Contrato(num, date, valor);
        ServicoContrato serv = new ServicoContrato();
        serv.processarContrato(jorge, parcelas, new ServicoPayPal());

        System.out.println("Parcelas:\n"+jorge);

        scanf.close();
    }
}
