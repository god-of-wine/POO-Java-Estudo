package entidades;

import java.util.ArrayList;

public class Livro extends ItemDeMidia{
    private String ISBN;
    private ArrayList<Autor> autores = new ArrayList<>();

    public Livro(String titulo, Integer lancamento, String ISBN) {
        super(titulo, lancamento);
        this.ISBN = ISBN;
    }

    public void addAutor(Autor autor){
        autores.add(autor);
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }

    public boolean pesquisar(String termo){
        return getTitulo().toLowerCase().contains(termo.toLowerCase());
    }

    public String visAutor(){
        StringBuilder sb = new StringBuilder();

        for(Autor autor : autores) sb.append(autor.getNome()).append("\n");

        return sb.toString();
    }

    @Override
    public String toString(){
        return ("Título = "+titulo+"\nAno Publicação = "+lancamento+"\nAutores:\n"+visAutor());
    }
}
