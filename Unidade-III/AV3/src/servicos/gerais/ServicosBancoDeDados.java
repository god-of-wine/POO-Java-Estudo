package servicos.gerais;

// imports de arquivos locais
import entidades.pacote.DimensaoCaixa;
import entidades.pacote.DimensaoCilindro;
import entidades.pacote.Pacote;
import servicos.frete_entrega.StatusEntrega;
import servicos.frete_entrega.TipoEntrega;

// outros imports
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/* Essa classe é apenas uma classe de métodos,
   suas funções apenas auxiliam no funcionamento
   do código, atuando indiretamente no que é exibido */
public class ServicosBancoDeDados {
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    /* Essa função foi utilizada no menu de adicionar pacotes,
       uma vez que ela adiciona um novo pacote ao banco de dados */
    public void addPacote(String descricao, Integer altura, Integer largura, Integer comprimento, Integer peso, 
                String nomeRemetente, String cepRemetente, String nomeDestinatario, String cepDestinatario,
                String cpfDestinatario, String endereco, String codigo, Double frete, Double dias, TipoEntrega tipoEntrega,
                StatusEntrega statusEntrega, Date dataEnvio, Date dataEntrega) {
        try(PrintWriter writer = new PrintWriter(Files.newBufferedWriter(Paths.get("src/entidades/BancoDeDados.csv"), java.nio.file.StandardOpenOption.APPEND))){
            writer.println(descricao+","+altura+","+largura+","+comprimento+","+peso+","+nomeRemetente+","+cepRemetente+","+nomeDestinatario+","+cepDestinatario+","
            +cpfDestinatario+","+endereco+","+codigo+","+frete+","+dias+","+tipoEntrega+","+statusEntrega+","+sdf.format(dataEnvio)+","+sdf.format(dataEntrega));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /* Essa função foi utilizada no menu de adicionar pacotes,
       sua utilidade é criar códigos com números aleatórios,
       de forma que seja extremamente difícil conseguir 2 códigos
       de rastreio iguais devido ao número de caracteres randômicos
       presentes na String */
    public String geraRastreio(){
        Random rand = new Random();
        int n1, n2, n3, n4, n5, n6, n7, n8;

        n1 = Math.abs((rand.nextInt()%10));
        n2 = Math.abs((rand.nextInt()%10));
        n3 = Math.abs((rand.nextInt()%10));
        n4 = Math.abs((rand.nextInt()%10));
        n5 = Math.abs((rand.nextInt()%10));
        n6 = Math.abs((rand.nextInt()%10));
        n7 = Math.abs((rand.nextInt()%10));
        n8 = Math.abs((rand.nextInt()%10));

        return ("BR"+n1+n2+n3+n4+n5+n6+n7+n8+"POO");
    }

    /* Essa função foi usada diversas vezes no código,
       tanto para mostrar informações vitais na tela,
       quanto para atualizar o banco de dados, ou até
       mesmo criar listas filtradas */
    public void createList(ArrayList<Pacote> listaBDD) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        listaBDD.clear();

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

    /* Essa função foi utilizada para atualizar o banco 
       de dados quando um item foi editado ou excluido.
       A função cria um arquivo temporario, deleta o antigo
       BancoDeDados.csv e renomeio o temporario para BancoDeDados.csv,
       utilizando a lista que foi passada como parâmetro para 
       reconstruir o banco de dados */
    public void updateBanco (ArrayList<Pacote> listaBBD){
        File auxiliar = new File("src/entidades", "temporario.csv");
        try {
            auxiliar.createNewFile();
            Files.delete(Paths.get("src/entidades/BancoDeDados.csv"));
            Files.move(Paths.get("src/entidades/temporario.csv"), Paths.get("src/entidades/BancoDeDados.csv"));
            
            for (Pacote pacote : listaBBD){
                if(pacote.getDimensao() instanceof DimensaoCaixa) addPacote(pacote.getDescricao(), pacote.getDimensao().getAltura(), ((DimensaoCaixa)pacote.getDimensao()).getLargura(), ((DimensaoCaixa)pacote.getDimensao()).getComprimento(), pacote.getPeso(), pacote.getNome_remetente(), pacote.getCep_remetente(), pacote.getNome_destinatario(), pacote.getCep_destinatario(), pacote.getCpf_destinatario(), pacote.getEndereco(), pacote.getCodigo(), pacote.getFrete(), pacote.getDias(), pacote.getTipo_entrega(), pacote.getStatus_entrega(), pacote.getData_envio(), pacote.getData_entrega());
                else addPacote(pacote.getDescricao(), pacote.getDimensao().getAltura(), ((DimensaoCilindro)pacote.getDimensao()).getDiametro(), 0, pacote.getPeso(), pacote.getNome_remetente(), pacote.getCep_remetente(), pacote.getNome_destinatario(), pacote.getCep_destinatario(), pacote.getCpf_destinatario(), pacote.getEndereco(), pacote.getCodigo(), pacote.getFrete(), pacote.getDias(), pacote.getTipo_entrega(), pacote.getStatus_entrega(), pacote.getData_envio(), pacote.getData_entrega());
            }
        } catch (IOException e){

        }
    }

    /* Essa função foi utilizada na Main, uma vez que
       ela só precisa ser executada no inicio do programa,
       atualizando os status dos pacotes a partir da
       data atual e, na main, utilizando o método updateBanco
       para escrever os dados novos no banco de dados */
    public void atualizaStatus (ArrayList<Pacote> lista) throws FileNotFoundException, ParseException {
        for(Pacote pacote : lista){
            if(pacote.getStatus_entrega() != StatusEntrega.OBJETO_ENTREGUE) {
            LocalDate hoje = LocalDate.now();
            LocalDate dataEntrega = pacote.getData_entrega().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate dataPostagem = pacote.getData_envio().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            
            if(hoje.equals(dataPostagem.plusDays(1))) {// se a data do dia for igual a data de entrega + 1 dia : objeto postado.
                pacote.setStatus_entrega(StatusEntrega.OBJETO_POSTADO);
            } else {
                if (hoje.equals(dataEntrega) || hoje.isAfter(dataEntrega)) {
                    pacote.setStatus_entrega(StatusEntrega.OBJETO_ENTREGUE);
                } else {
                    pacote.setStatus_entrega(StatusEntrega.OBJETO_EM_TRANSITO);
                }
            }
            }
        }
        
    }
}
