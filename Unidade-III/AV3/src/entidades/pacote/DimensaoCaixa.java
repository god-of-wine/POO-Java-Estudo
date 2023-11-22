package entidades.pacote;

public class DimensaoCaixa extends Dimensao{
    private Integer comprimento, largura;

    public DimensaoCaixa(Integer altura, Integer largura, Integer comprimento) {
        super(altura);
        this.largura = largura;
        this.comprimento = comprimento;
    }

    public Integer getComprimento() {
        return comprimento;
    }
    public void setComprimento(Integer comprimento) {
        this.comprimento = comprimento;
    }
    public Integer getLargura() {
        return largura;
    }
    public void setLargura(Integer largura) {
        this.largura = largura;
    }

    @Override
    public String toString(){
        return (super.getAltura()+" x "+largura+" x "+comprimento+" cm³");
    }
}
