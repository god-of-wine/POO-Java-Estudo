package entidades;

import servicos.StatusEntrega;
import servicos.TipoEntrega;

public class Pacote {
    private String descricao;
    private Integer altura, largura, comprimento, peso;
    private String nome_remetente, cep_remetente;
    private String nome_destinatario, cep_destinatario, cpf_destinatario, endereco;
    private String codigo;
    private Double frete, dias;
    private TipoEntrega tipo_entrega;
    private StatusEntrega status_entrega;
    
    public Pacote(String descricao, Integer altura, Integer largura, Integer comprimento, Integer peso,
            String nome_remetente, String cep_remetente, String nome_destinatario, String cep_destinatario,
            String cpf_destinatario, String endereco, String codigo, Double frete, Double dias, 
            TipoEntrega tipo_entrega, StatusEntrega status_entrega) {
        this.descricao = descricao;
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
        this.peso = peso;
        this.nome_remetente = nome_remetente;
        this.cep_remetente = cep_remetente;
        this.nome_destinatario = nome_destinatario;
        this.cep_destinatario = cep_destinatario;
        this.cpf_destinatario = cpf_destinatario;
        this.endereco = endereco;
        this.codigo = codigo;
        this.frete = frete;
        this.dias = dias;
        this.tipo_entrega = tipo_entrega;
        this.status_entrega = status_entrega;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Integer getAltura() {
        return altura;
    }
    public void setAltura(Integer altura) {
        this.altura = altura;
    }
    public Integer getLargura() {
        return largura;
    }
    public void setLargura(Integer largura) {
        this.largura = largura;
    }
    public Integer getComprimento() {
        return comprimento;
    }
    public void setComprimento(Integer comprimento) {
        this.comprimento = comprimento;
    }
    public Integer getPeso() {
        return peso;
    }
    public void setPeso(Integer peso) {
        this.peso = peso;
    }
    public String getNome_remetente() {
        return nome_remetente;
    }
    public void setNome_remetente(String nome_remetente) {
        this.nome_remetente = nome_remetente;
    }
    public String getCep_remetente() {
        return cep_remetente;
    }
    public void setCep_remetente(String cep_remetente) {
        this.cep_remetente = cep_remetente;
    }
    public String getNome_destinatario() {
        return nome_destinatario;
    }
    public void setNome_destinatario(String nome_destinatario) {
        this.nome_destinatario = nome_destinatario;
    }
    public String getCep_destinatario() {
        return cep_destinatario;
    }
    public void setCep_destinatario(String cep_destinatario) {
        this.cep_destinatario = cep_destinatario;
    }
    public String getCpf_destinatario() {
        return cpf_destinatario;
    }
    public void setCpf_destinatario(String cpf_destinatario) {
        this.cpf_destinatario = cpf_destinatario;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public Double getFrete() {
        return frete;
    }
    public void setFrete(Double frete) {
        this.frete = frete;
    }
    public Double getDias() {
        return dias;
    }
    public void setDias(Double dias) {
        this.dias = dias;
    }
    public TipoEntrega getTipo_entrega() {
        return tipo_entrega;
    }
    public void setTipo_entrega(TipoEntrega tipo_entrega) {
        this.tipo_entrega = tipo_entrega;
    }
    public StatusEntrega getStatus_entrega() {
        return status_entrega;
    }
    public void setStatus_entrega(StatusEntrega status_entrega) {
        this.status_entrega = status_entrega;
    }
}
