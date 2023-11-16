package servicos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
import java.util.Random;

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
            writer.println(descricao+","+altura+","+largura+","+comprimento+","+peso+","+nomeRemetente+","+cepRemetente+","+nomeDestinatario+","+cepDestinatario+","
            +cpfDestinatario+","+endereco+","+codigo+","+frete+","+dias+","+tipoEntrega+","+statusEntrega+","+sdf.format(dataEnvio)+","+sdf.format(dataEntrega));
        }catch (IOException e){
            e.printStackTrace();
        }

        if(comprimento==0) lista.add(new Pacote(descricao, new DimensaoCilindro(altura, largura), peso, nomeRemetente, cepRemetente, nomeDestinatario, cepDestinatario, cpfDestinatario, endereco, codigo, frete, dias, tipoEntrega, statusEntrega, dataEnvio, dataEntrega));
        else lista.add(new Pacote(descricao, new DimensaoCaixa(altura, largura, comprimento), peso, nomeRemetente, cepRemetente, nomeDestinatario, cepDestinatario, cpfDestinatario, endereco, codigo, frete, dias, tipoEntrega, statusEntrega, dataEnvio, dataEntrega));
    }

    public String geraRastreio(){
        Random rand = new Random();
        int n1, n2, n3, n4, n5;

        n1 = Math.abs((rand.nextInt()%10));
        n2 = Math.abs((rand.nextInt()%10));
        n3 = Math.abs((rand.nextInt()%10));
        n4 = Math.abs((rand.nextInt()%10));
        n5 = Math.abs((rand.nextInt()%10));

        return ("BR"+n1+n2+n3+n4+n5+"POO");
    }

    public void createList(ArrayList<Pacote> listaBDD) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        listaBDD.clear();

        // ler as linhas do arquivo
        try(BufferedReader bReader = new BufferedReader(new FileReader("src/entidades/BancoDeDados.csv"))){
            String linha = bReader.readLine();

            while(linha != null){
                String[] campos = linha.split(",");
                if(Integer.parseInt(campos[3]) == 0) listaBDD.add(new Pacote(campos[0], new DimensaoCilindro(Integer.parseInt(campos[1]), Integer.parseInt(campos[2])), Integer.parseInt(campos[4]), campos[5], campos[6], campos[7], campos[8], campos[9], campos[10], campos[11], Double.parseDouble(campos[12]), Double.parseDouble(campos[13]), TipoEntrega.valueOf(campos[14]), StatusEntrega.valueOf(campos[15]), sdf.parse(campos[16]), sdf.parse(campos[17])));
                else listaBDD.add(new Pacote(campos[0], new DimensaoCaixa(Integer.parseInt(campos[1]), Integer.parseInt(campos[2]), Integer.parseInt(campos[3])), Integer.parseInt(campos[4]), campos[5], campos[6], campos[7], campos[8], campos[9], campos[10], campos[11], Double.parseDouble(campos[12]), Double.parseDouble(campos[13]), TipoEntrega.valueOf(campos[14]), StatusEntrega.valueOf(campos[15]), sdf.parse(campos[16]), sdf.parse(campos[17])));
                linha = bReader.readLine();
            }
        } catch(IOException e){
            
        }
    }

    public void atualizaBanco (Pacote pacote) throws FileNotFoundException, ParseException {

        File banco = new File("/src/entidades/BancoDeDados.csv");

        Scanner input = new Scanner(banco);

        while(input.hasNextLine()) {

            String line = input.nextLine(); 
            String info[] = line.split(",");

            if(info[15] != "OBJETO_ENTREGUE") {

                // if(sdf.parse(info[16]) == java.sql.Date.valueOf(LocalDate.now())) {// se a data de envio for igual a data do dia: pagamento pendente.
                //     info[15] = "PAGAMENTO_PENDENTE";
                // } 
                // REDUNDANTE, POIS TODOS OS STATUS POR DEFAULT SERÃO DEFINIDOS COMO "PAGAMENTO_PENDENTE".

                if(java.sql.Date.valueOf(LocalDate.now()) == addDay(sdf.parse(info[17]))) {// se a data do dia for igual a data de entrega + 1 dia : objeto postado.
                    info[15] = "OBJETO_POSTADO";
                }

                if(java.sql.Date.valueOf(LocalDate.now()) == sdf.parse(info[17])) {// se a data do dia for igual a data de entrega : objeto entregue.
                    info[15] = "OBJETO_ENTREGUE";
                }

                else {
                    info[15] = "OBJETO_EM_TRANSITO";
                }

            }

        }

        /* CONVENÇÕES DA STRING[] (Vetor de Strings)
        info[0] = descrição
        info[1] = peso
        info[2] = nome Remetente
        info[3] = cep Remetente
        info[4] = nome destinatario
        info[5] = cep Destinatario
        info[6] = cpf destinatario
        info[7] = endereco destinatario
        info[8] = codigo de postagem
        info[9] = frete entrega
        info[10] = dias entrega
        info[11] = tipo frete entrega
        info[12] = status pagamento
        info[13] = data envio
        info[14] = data entrega
        */

        input.close();
    }

    // Método para pegar as info do csv e por numa lista
    public static void addCSVinList(File caminhoDoArquivo) throws FileNotFoundException {
        
        Scanner input = new Scanner(caminhoDoArquivo);
        
        while (input.hasNextLine()) {
            //String line = input.nextLine();
            //String[] info = line.split(",");

            //Pacote pacote = new Pacote();

        }


        input.close();
    }

    // Método para adicionar um dia a uma data
    private static Date addDay(Date data) {
        long umDiaEmMs = 24 * 60 * 60 * 1000; // Um dia em milissegundos
        return new Date(data.getTime() + umDiaEmMs); // criando uma nova Date com o valor da anterior + o valor de 1 dia em Ms.
    }


    //Método para pegar as info de uma lista e porno csv

}
