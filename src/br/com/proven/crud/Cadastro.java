package br.com.proven.crud;

import br.com.proven.collections.Clientes;
import br.com.proven.collections.Funcionarios;
import br.com.proven.collections.Produtos;
import br.com.proven.collections.Vendas;
import br.com.proven.entities.Cliente;
import br.com.proven.entities.Funcionario;
import br.com.proven.entities.Produto;
import br.com.proven.entities.Venda;
import br.com.proven.exceptions.ConversaoException;
import br.com.proven.exceptions.ListaVaziaException;
import br.com.proven.exceptions.ValorNegativoException;

import java.util.Scanner;

public class Cadastro {

    public static void cadastrarCliente(Scanner sc) {
        try {
            Cliente cliente = Criar.criarCliente(sc);
            Clientes.adicionarCliente(cliente);
        } catch (ValorNegativoException | ConversaoException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void cadastrarProduto(Scanner sc) {
        try {
            Produto produto = Criar.criarProduto(sc);
            Produtos.adicionarProduto(produto);
        } catch (ValorNegativoException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void cadastrarFuncionario(Scanner sc) {
        try {
            Funcionario funcionario = Criar.criarFuncionario(sc);
            Funcionarios.adicionarFuncionario(funcionario);
        } catch (ValorNegativoException | ConversaoException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void cadastrarVenda(Scanner sc) {
        try {
            Venda venda = Criar.criarVenda(sc);
            Vendas.adicionarVenda(venda);
        } catch (ValorNegativoException | ListaVaziaException | ConversaoException e) {
            System.out.println(e.getMessage());
        }
    }

}
