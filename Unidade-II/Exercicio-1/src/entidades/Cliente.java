package entidades;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Cliente {
    private String nome, email;
    private Date nascimento;
    private SimpleDateFormat sdf = new SimpleDateFormat("(dd/MM/yyyy)");

    public Cliente(String nome, String email, Date nascimento){
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
    }

    public String toString(){
        return (this.nome+" "+sdf.format(this.nascimento)+" - "+this.email);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }
}
