package entidades;

public class ConversorMoeda {

    public float cotacao(float dolar, float quantidade){
        return dolar*quantidade+(dolar*quantidade)*6/100;
    }

}
