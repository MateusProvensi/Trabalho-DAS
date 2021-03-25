package br.com.proven.application;

import br.com.proven.collections.Clientes;
import br.com.proven.collections.Funcionarios;
import br.com.proven.collections.Produtos;
import br.com.proven.collections.Vendas;
import br.com.proven.entities.Cliente;
import br.com.proven.entities.Funcionario;
import br.com.proven.entities.Produto;
import br.com.proven.entities.Venda;
import br.com.proven.util.Util;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Util util = new Util();

        Clientes.adicionarCliente(new Cliente("Jaspion", "Silva", "123484", 15.00));
        Clientes.adicionarCliente(new Cliente("Guse", "Silva", "123484", 500.00));
        Clientes.adicionarCliente(new Cliente("Moyse", "Silva", "123484", 600.00));
        Clientes.adicionarCliente(new Cliente("Caeca", "Silva", "123484", 900.00));
        Clientes.adicionarCliente(new Cliente("Nisil", "Silva", "123484", 1900.00));

        Produtos.adicionarProduto(new Produto("Coca", "LT", 5.00));
        Produtos.adicionarProduto(new Produto("Pepsi", "LT", 4.00));
        Produtos.adicionarProduto(new Produto("Hamburguer", "UN", 9.00));

        Funcionarios.adicionarFuncionario(new Funcionario("Lioga", "Souza", "4651216", 1500.00));
        Funcionarios.adicionarFuncionario(new Funcionario("Pehiu", "Souza", "4651216", 1800.00));
        Funcionarios.adicionarFuncionario(new Funcionario("Fibya", "Souza", "4651216", 1900.00));
        Funcionarios.adicionarFuncionario(new Funcionario("Topo", "Souza", "4651216", 2000.00));

        Venda venda1 = new Venda(0.0, Clientes.getClientes().get(0), Funcionarios.getFuncionarios().get(0));
        venda1.adicionarProduto(Produtos.getProdutos().get(0));
        venda1.adicionarProduto(Produtos.getProdutos().get(0));
        venda1.adicionarProduto(Produtos.getProdutos().get(1));

        Vendas.adicionarVenda(venda1);


        boolean continuar = true;
        while (continuar) {
            for (int i = 0; i < 50; ++i) System.out.println ();
            continuar = util.menuPrincipal(sc);
            System.out.println("Pressione enter para continuar");
            sc.nextLine();
        }

        sc.close();
    }
}
