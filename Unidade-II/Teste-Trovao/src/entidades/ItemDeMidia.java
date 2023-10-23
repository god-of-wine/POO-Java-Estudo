package entidades;

import servicos.Pesquisavel;

public abstract class ItemDeMidia implements Pesquisavel{
    protected String titulo;
    protected Integer lancamento;

    public ItemDeMidia(String titulo, Integer lancamento) {
        this.titulo = titulo;
        this.lancamento = lancamento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getLancamento() {
        return lancamento;
    }

    public void setLancamento(Integer lancamento) {
        this.lancamento = lancamento;
    }
}
