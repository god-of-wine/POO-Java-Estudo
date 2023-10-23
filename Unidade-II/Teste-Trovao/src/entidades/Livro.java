package entidades;

public class Livro extends ItemDeMidia{
    private String ISBN;
    private Autor autor;

    public Livro(String titulo, Integer lancamento, String ISBN, Autor autor) {
        super(titulo, lancamento);
        this.ISBN = ISBN;
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public boolean pesquisar(String termo){
        return getTitulo().toLowerCase().contains(termo.toLowerCase());
    }
}
