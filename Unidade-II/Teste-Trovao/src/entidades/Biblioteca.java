package entidades;

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<ItemDeMidia> acervo = new ArrayList<>();

    public void addItem(ItemDeMidia item){
        acervo.add(item);
    }
    public boolean remItem(ItemDeMidia item){
        if(acervo.remove(item)) return true;
        return false;
    }

    public String pesquisarItem(String nome){
        StringBuilder sb = new StringBuilder();
        for(ItemDeMidia item : acervo)
           if(item.pesquisar(nome)) sb.append("Título: "+item.getTitulo()+"\n");
        return sb.toString();
    }

    public ArrayList<ItemDeMidia> getAcervo() {
        return acervo;
    }
    public void setAcervo(ArrayList<ItemDeMidia> naruto) {
        this.acervo = naruto;
    }
}
