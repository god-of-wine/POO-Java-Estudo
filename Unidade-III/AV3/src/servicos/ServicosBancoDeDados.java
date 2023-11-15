package servicos;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import entidades.DimensaoCaixa;
import entidades.DimensaoCilindro;
import entidades.Pacote;

public class ServicosBancoDeDados {
    private SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");

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
}
