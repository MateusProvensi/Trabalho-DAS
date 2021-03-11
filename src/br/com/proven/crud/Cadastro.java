package br.com.proven.crud;

import br.com.proven.collections.Clientes;
import br.com.proven.collections.Funcionarios;
import br.com.proven.collections.Produtos;
import br.com.proven.collections.Vendas;
import br.com.proven.entities.Cliente;
import br.com.proven.entities.Funcionario;
import br.com.proven.entities.Produto;
import br.com.proven.entities.Venda;

import java.util.Scanner;

public class Cadastro {

    public static void cadastrarCliente(Scanner sc) {
        Cliente cliente = Criar.criarCliente(sc);
        Clientes.adicionarCliente(cliente);
    }

    public static void cadastrarProduto(Scanner sc) {
        Produto produto = Criar.criarProduto(sc);
        Produtos.adicionarProduto(produto);
    }

    public static void cadastrarFuncionario(Scanner sc) {
        Funcionario funcionario = Criar.criarFuncionario(sc);
        Funcionarios.adicionarFuncionario(funcionario);
    }

    public static void cadastrarVenda(Scanner sc) {
        Venda venda = Criar.criarVenda(sc);
        Vendas.adicionarVenda(venda);
    }

}
