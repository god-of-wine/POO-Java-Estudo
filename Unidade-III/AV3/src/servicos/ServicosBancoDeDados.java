package servicos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import entidades.DimensaoCaixa;
import entidades.DimensaoCilindro;
import entidades.Pacote;

public class ServicosBancoDeDados {
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public void addPacote(String descricao, Integer altura, Integer largura, Integer comprimento, Integer peso, 
                String nomeRemetente, String cepRemetente, String nomeDestinatario, String cepDestinatario,
                String cpfDestinatario, String endereco, String codigo, Double frete, Double dias, TipoEntrega tipoEntrega,
                StatusEntrega statusEntrega, Date dataEnvio, Date dataEntrega, ArrayList<Pacote> lista) {
        try(PrintWriter writer = new PrintWriter(Files.newBufferedWriter(Paths.get("src/entidades/BancoDeDados.csv"), java.nio.file.StandardOpenOption.APPEND))){
            writer.println(descricao+", "+altura+", "+largura+", "+comprimento+", "+peso+", "+nomeRemetente+", "+cepRemetente+", "+nomeDestinatario+", "
            +cpfDestinatario+", "+endereco+", "+codigo+", "+frete+", "+dias+", "+tipoEntrega+", "+statusEntrega+", "+sdf.format(dataEnvio)+", "+sdf.format(dataEntrega));
        }catch (IOException e){
            e.printStackTrace();
        }

        if(comprimento==0) lista.add(new Pacote(descricao, new DimensaoCilindro(altura, largura), peso, nomeRemetente, cepRemetente, nomeDestinatario, cepDestinatario, cpfDestinatario, endereco, codigo, frete, dias, tipoEntrega, statusEntrega, dataEnvio, dataEntrega));
        else lista.add(new Pacote(descricao, new DimensaoCaixa(altura, largura, comprimento), peso, nomeRemetente, cepRemetente, nomeDestinatario, cepDestinatario, cpfDestinatario, endereco, codigo, frete, dias, tipoEntrega, statusEntrega, dataEnvio, dataEntrega));
    }

    public void atualizaBanco (Pacote pacote) throws FileNotFoundException, ParseException {

        File banco = new File("/src/entidades/BancoDeDados.csv");

        Scanner input = new Scanner(banco);

        while(input.hasNextLine()) {

            String line = input.nextLine();
            String info[] = line.split(",");

            if(sdf.parse(info[16]) == java.sql.Date.valueOf(LocalDate.now())) {// se a data de envio for igual a data do dia: pagamento pendente.
                info[15] = "PAGAMENTO_PENDENTE";
            }

            // if(java.sql.Date.valueOf(LocalDate.now()) == sdf.parse(info[16]).plusDays(1)) {// se a data do dia for igual a data de entrega + 1 dia : objeto postado.

            // }

            if(java.sql.Date.valueOf(LocalDate.now()) == sdf.parse(info[17])) {// se a data do dia for igual a data de entrega : objeto entregue.
                info[15] = "OBJETO_ENTREGUE";
            }

            else {
                info[15] = "OBJETo_EM_TRANSITO";
            }

            


        }

        //info[0] = descrição
        //info[1] = altura
        //info[2] = largura
        //info[3] = comprimento
        //info[4] = peso
        //info[5] = nome Remetente
        //info[6] = cep Remetente
        //info[7] = nome destinatario
        //info[8] = cep Destinatario
        //info[9] = cpf destinatario
        //info[10] = endereco destinatario
        //info[11] = codigo de postagem
        //info[12] = frete entrega
        //info[13] = dias entrega
        //info[14] = tipo frete entrega
        //info[15] = status pagamento
        //info[16] = data envio
        //info[17] = data entrega

        input.close();
    }

}
