package br.com.proven.entities;

import java.util.ArrayList;
import java.util.List;

public class Venda {

    private Double subTotal;
    private Double desconto;
    private Cliente cliente;
    private Funcionario funcionario;

    private Double valorTotal;
    private List<Produto> produtosDaVenda = new ArrayList<>();

    public Venda(Double subTotal, Double desconto, Cliente cliente, Funcionario funcionario) {
        this.subTotal = subTotal;
        this.desconto = desconto;
        this.cliente = cliente;
        this.funcionario = funcionario;
    }

    public Double getSubTotal() {
        return this.subTotal;
    }

    public Double getDesconto() {
        return this.desconto;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public Funcionario getFuncionario() {
        return this.funcionario;
    }

    public List<Produto> getProdutosDaVenda() {
        return this.produtosDaVenda;
    }

    public Double getValorTotal() {
        this.valorTotal = this.subTotal - this.desconto;
        return this.valorTotal;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void adicionarProduto(Produto produto) {
        this.produtosDaVenda.add(produto);
    }

    public void removerProduto(Produto produto) {
        this.produtosDaVenda.remove(produto);
    }

    @Override
    public String toString() {
        return "Venda{" +
                "subTotal=" + subTotal +
                ", desconto=" + desconto +
                ", cliente=" + cliente +
                ", funcionario=" + funcionario +
                ", valorTotal=" + valorTotal +
                ", produtosDaVenda=" + produtosDaVenda +
                '}';
    }
}
