package entidades;

import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Postagens {
    private Date momento;
    private String titulo, conteudo;
    private Integer curtidas=0;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    List<Comentarios> comentarios = new ArrayList<>();

    public Postagens(Date momento, String titulo, String conteudo){
        this.momento = momento;
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

    public void Curtir(){
        this.curtidas+=1;
    }

    public void addComentario(Comentarios comentario){
        comentarios.add(comentario);
    }
    public void remComentario(Comentarios comentario){
        comentarios.remove(comentario);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Título - ").append(this.titulo)
                .append("\nData - ").append(sdf.format(this.momento))
                .append(" Curtidas - ").append(this.curtidas)
                .append("\nComentários:\n");
    
        for (Comentarios come : comentarios) {
            sb.append("-").append(come).append("\n");
        }
    
        return sb.toString();
    }

    //getters e setters
    public Date getMomento() {
        return momento;
    }
    public void setMomento(Date momento) {
        this.momento = momento;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getConteudo() {
        return conteudo;
    }
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
    public Integer getCurtidas() {
        return curtidas;
    }
    public void setCurtidas(Integer curtidas) {
        this.curtidas = curtidas;
    }  
}
