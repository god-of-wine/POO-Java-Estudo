package aplicacao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;

import entidades.Produto;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Produto> lista = new ArrayList<>();

        System.out.printf("Digite o caminho do arquivo: "); String caminho = input.nextLine();
        File arquivo = new File(caminho);

        try (BufferedReader bc = new BufferedReader(new FileReader(arquivo))) {
            String linha = bc.readLine();
            System.out.printf("Digite o caminho onde deseja criar o resumo: "); String resposta = input.nextLine();
            boolean cria = new File(resposta + "\\resposta").mkdir();
            resposta += "\\resposta\\resumo.csv";
            System.out.println("Arquivo criado: "+cria);
            if(!cria) return;

            while(linha != null) {
                String[] campos = linha.split(",");
                lista.add(new Produto(campos[0], Double.parseDouble(campos[1]), Integer.parseInt(campos[2])));
                try (BufferedWriter br = new BufferedWriter(new FileWriter(resposta))){
                    for(Produto item: lista){
                        br.write(item.getNome()+","+String.format("%.2f", item.getValor()*item.getQuantidade()));
                        br.newLine();
                    }
                } catch(IOException e){
                    System.out.println("Erro: "+e.getMessage());
                }

                linha = bc.readLine();
            }

        } catch(IOException e){
            System.out.println("Erro: "+e.getMessage());
        }
        input.close();
    }
}
