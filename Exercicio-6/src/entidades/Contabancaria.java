package entidades;

public class Contabancaria {
    private Integer id;
    private String nome;
    private Float saldo;

    public Contabancaria(Integer id, String nome, Float saldo){
        this.id = id;
        this.nome = nome;
        this.saldo = saldo;
    }

    public Contabancaria(Integer id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public void addSaldo(float quantidade){
        this.saldo += quantidade;
    }

    public void remSaldo(float quantidade){
        this.saldo -= quantidade;
    }

    public String toString(){
        return ("Conta " +id+", Nome do titular: "+nome+", Saldo: R$ "+String.format("%.2f", saldo));
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Float getSaldo() {
        return saldo;
    }
    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    
}
