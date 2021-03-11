package br.com.proven.entities;

import java.util.ArrayList;
import java.util.List;

public class Venda {

    private Double desconto;
    private Cliente cliente;
    private Funcionario funcionario;

    private Double subTotal;
    private Double valorTotal;
    private List<Produto> produtosDaVenda = new ArrayList<>();

    public Venda(Double desconto, Cliente cliente, Funcionario funcionario) {
        this.desconto = desconto;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.subTotal = 0.0;
        this.valorTotal = 0.0;
    }

    private void calcularSubTotal() {
        Double subTotalCalculado = 0.0;
        for (Produto produto : produtosDaVenda) {
            subTotalCalculado += produto.getValor();
        }
        this.subTotal = subTotalCalculado;
        calcularValorTotal();
    }

    private void calcularValorTotal() {
        this.valorTotal = this.subTotal - this.desconto;
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
        return this.valorTotal;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
        calcularSubTotal();
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void adicionarProduto(Produto produto) {
        this.produtosDaVenda.add(produto);
        calcularSubTotal();
    }

    public void removerProduto(Produto produto) {
        this.produtosDaVenda.remove(produto);
        calcularSubTotal();
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
