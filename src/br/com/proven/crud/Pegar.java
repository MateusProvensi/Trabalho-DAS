package br.com.proven.crud;

import br.com.proven.collections.Clientes;
import br.com.proven.collections.Funcionarios;
import br.com.proven.collections.Produtos;
import br.com.proven.collections.Vendas;
import br.com.proven.entities.Cliente;
import br.com.proven.entities.Funcionario;
import br.com.proven.entities.Produto;
import br.com.proven.entities.Venda;
import br.com.proven.exceptions.ListaVaziaException;

import java.util.List;
import java.util.Scanner;

public class Pegar {

    public static Cliente pegarCliente(Scanner sc) {

        try {

            List<Cliente> clientes = Clientes.getClientes();

            if (clientes.size() == 0) {
                throw new ListaVaziaException("A lista de clientes esta vazia");
            }

            for (int i = 0; i < clientes.size(); i++) {
                System.out.println(i + " - " + clientes.get(i).getNome());
            }

            System.out.print("Digite o indice do cliente: ");
            Integer index = (Integer) sc.nextInt();

            return clientes.get(index);
        } catch (ListaVaziaException e) {
            throw new ListaVaziaException(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro");
        }
    }

    public static Funcionario pegarFuncionario(Scanner sc) {

        try {

            List<Funcionario> funcionarios = Funcionarios.getFuncionarios();

            if (funcionarios.size() == 0) {
                throw new ListaVaziaException("A lista de funcionarios esta vazia");
            }

            for (int i = 0; i < funcionarios.size(); i++) {
                System.out.println(i + " - " + funcionarios.get(i).getNome());
            }

            System.out.print("Digite o indice do funcionario: ");
            Integer index = (Integer) sc.nextInt();

            return funcionarios.get(index);
        } catch (ListaVaziaException e) {
            throw new ListaVaziaException(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro");
        }
    }

    public static Produto pegarProduto(Scanner sc) {

        try {

            List<Produto> produtos = Produtos.getProdutos();

            if (produtos.size() == 0) {
                throw new ListaVaziaException("A lista de produtos está vazia");
            }

            for (int i = 0; i < produtos.size(); i++) {
                System.out.println(i + " - " + produtos.get(i).getDescricao());
            }

            System.out.print("Digite o indice do produto: ");
            Integer index = (Integer) sc.nextInt();

            return produtos.get(index);
        } catch (ListaVaziaException e) {
            throw new ListaVaziaException(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro");
        }
    }

    public static Venda pegarVenda(Scanner sc) {

        try {

            List<Venda> vendas = Vendas.getVendas();

            if (vendas.size() == 0) {
                throw new ListaVaziaException("A lista de vendas esta vazia");
            }

            for (int i = 0; i < vendas.size(); i++) {
                System.out.println(i + " - " + vendas.get(i));
            }

            System.out.print("Digite o indice do produto: ");
            Integer index = (Integer) sc.nextInt();

            return vendas.get(index);
        } catch (ListaVaziaException e) {
            throw new ListaVaziaException(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro");
        }
    }

    public static void pegarProdutoVenda(Scanner sc, Venda venda) {
        try {
            while (true) {
                System.out.println("1 - Adicionar mais");
                System.out.println("2 - Finalizar");

                System.out.print("Digite a sua escolha: ");
                String escolha = sc.nextLine();

                if (escolha.equals("2")) {
                    break;
                }
                Produto produto = Pegar.pegarProduto(sc);
                venda.adicionarProduto(produto);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
