package entidades;

public class DimensaoCilindro extends Dimensao{
    private Integer diametro;

    public DimensaoCilindro(Integer altura, Integer diametro) {
        super(altura);
        this.diametro = diametro;
    }

    public Integer getDiametro() {
        return diametro;
    }

    public void setDiametro(Integer diametro) {
        this.diametro = diametro;
    }
}
