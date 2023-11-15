package servicos;

public enum TipoEntrega {
    ECONOMICA ("Econômica"),
    EXPRESSA ("Expressa");

    private final String nome;

    private TipoEntrega(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }
}
