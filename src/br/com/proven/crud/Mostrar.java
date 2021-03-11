package br.com.proven.crud;

import br.com.proven.entities.Cliente;
import br.com.proven.entities.Funcionario;
import br.com.proven.entities.Produto;
import br.com.proven.entities.Venda;

import java.util.List;

public class Mostrar {

    public static void mostrarCliente(Cliente cliente) {
        System.out.println("Nome(editavel) | Sobrenome(editavel) | CPF(editavel) | limite(editavel)");
        System.out.println(cliente.mostrarDados());
    }

    public static void mostrarTodosClientes(List<Cliente> clientes) {
        System.out.println("Nome(editavel) | Sobrenome(editavel) | CPF(editavel) | limite(editavel)");
        clientes.forEach((cliente) -> System.out.println(cliente.mostrarDados()));
    }

    public static void mostrarFuncionario(Funcionario funcionario) {
        System.out.println("Nome(editavel) | Sobrenome(editavel) | CPF(editavel) | salario(editavel)");
        System.out.println(funcionario.mostrarDados());
    }

    public static void mostrarTodosFuncionarios(List<Funcionario> funcionarios) {
        System.out.println("Nome(editavel) | Sobrenome(editavel) | CPF(editavel) | salario(editavel)");
        funcionarios.forEach((funcionario) -> System.out.println(funcionario.mostrarDados()));
    }

    public static void mostrarProduto(Produto produto) {
        System.out.println("Descricao(editavel) | Unidade de medida(editavel) | valor(editalvel)");
        System.out.println(produto.mostrarDados());
    }

    public static void mostrarTodosProdutos(List<Produto> produtos) {
        System.out.println("Descricao(editavel) | Unidade de medida(editavel) | valor(editalvel)");
        produtos.forEach((produto) -> System.out.println(produto.mostrarDados()));
    }

    public static void mostrarVenda(Venda venda) {
        System.out.println("SubTotal(acrecentavel) | Total(acrecentavel) | Desconto(editavel) | Cliente(edital) | " +
                "Funcionario(editavel) | Produtos(acrecentavel) | ");
        System.out.println(venda.mostrarDados());
    }

    public static void mostrarTodasVendas(List<Venda> vendas) {
        System.out.println("SubTotal(acrecentavel) | Total(acrecentavel) | Desconto(editavel) | Cliente(edital) | " +
                "Funcionario(editavel) | Produtos(acrecentavel) | ");
        vendas.forEach((venda) -> System.out.println(venda.mostrarDados()));
    }

}
