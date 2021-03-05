package br.com.proven.entities;

public class Produto {

    private String descricao;
    private String unidadeMedida;
    private Double valor;

    public Produto(String descricao, String unidadeMedida, Double valor) {
        this.descricao = descricao;
        this.unidadeMedida = unidadeMedida;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public Double getValor() {
        return valor;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "descricao='" + descricao + '\'' +
                ", unidadeMedida='" + unidadeMedida + '\'' +
                ", valor=" + valor +
                '}';
    }
}
