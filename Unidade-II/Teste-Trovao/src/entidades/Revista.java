package entidades;

public class Revista extends ItemDeMidia{
    private Integer edicao;

    public Revista(String titulo, Integer lancamento, Integer edicao) {
        super(titulo, lancamento);
        this.edicao = edicao;
    }

    public Integer getEdicao() {
        return edicao;
    }

    public void setEdicao(Integer edicao) {
        this.edicao = edicao;
    }

    public boolean pesquisar(String termo){
        return getTitulo().toLowerCase().contains(termo.toLowerCase());
    }
}
