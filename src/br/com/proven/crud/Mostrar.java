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
        for (Cliente cliente : clientes) {
            System.out.println(cliente.mostrarDados());
        }
    }

    public static void mostrarFuncionario(Funcionario funcionario) {

    }

    public static void mostrarTodosFuncionarios(List<Funcionario> funcionarios) {

    }

    public static void mostrarProduto(Produto produto) {

    }

    public static void mostrarTodosProdutos(List<Produto> produtos) {

    }

    public static void mostrarVenda(Venda venda) {

    }

    public static void mostrarTodasVendas(List<Venda> vendas) {

    }

}
