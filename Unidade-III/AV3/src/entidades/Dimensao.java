package entidades;

public abstract class Dimensao {
    private Integer altura;

    public Dimensao(Integer altura) {
        this.altura = altura;
    }

    public Integer getAltura() {
        return altura;
    }
    public void setAltura(Integer altura) {
        this.altura = altura;
    }
}
