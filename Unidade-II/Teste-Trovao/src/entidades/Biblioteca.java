package entidades;

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<ItemDeMidia> naruto = new ArrayList<>();

    public void addItem(ItemDeMidia item){
        naruto.add(item);
    }
    public boolean remItem(ItemDeMidia item){
        if(naruto.remove(item)) return true;
        return false;
    }

    public String pesquisarItem(String nome){
        for(ItemDeMidia item : naruto){
           if(item.pesquisar(nome)) return ("Título: "+item.getTitulo()+"\n");
        }
        return "Título não encontrado\n";
    }

    public ArrayList<ItemDeMidia> getNaruto() {
        return naruto;
    }
    public void setNaruto(ArrayList<ItemDeMidia> naruto) {
        this.naruto = naruto;
    }
}
