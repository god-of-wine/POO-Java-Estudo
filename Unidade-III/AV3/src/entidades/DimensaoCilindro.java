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

    @Override
    public String toString(){
        return (super.getAltura()+" x "+String.format("%.1f² x %.2f cm³", (double)(diametro/2), Math.PI));
    }
}
