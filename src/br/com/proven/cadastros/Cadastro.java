package br.com.proven.cadastros;

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

public class Cadastro {

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
            int index = sc.nextInt();

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
            int index = sc.nextInt();

            return funcionarios.get(index);
        } catch (ListaVaziaException e){
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
            int index = sc.nextInt();

            return produtos.get(index);
        } catch (ListaVaziaException e){
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
            int index = sc.nextInt();

            return vendas.get(index);
        } catch (ListaVaziaException e){
            throw new ListaVaziaException(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro");
        }
    }

    public static Cliente cadastrarCliente(Scanner sc) {

        try {

            System.out.print("Digite o nome: ");
            String nome = sc.nextLine();

            System.out.print("Digite o sobrenome: ");
            String sobrenome = sc.nextLine();

            System.out.print("Digite o cpf: ");
            String cpf = sc.nextLine();

            System.out.print("Digite o limite: ");
            Double limite = sc.nextDouble();

            return new Cliente(nome, sobrenome, cpf, limite);
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro");
        }


    }

    public static Produto cadastrarProduto(Scanner sc) {

        try {

            System.out.println("Digite a descrição: ");
            String descricao = sc.nextLine();

            System.out.println("Digite a unidade de medida: ");
            String unidadeMedida = sc.nextLine();

            System.out.println("Digite o valor: ");
            Double valor = sc.nextDouble();

            return new Produto(descricao, unidadeMedida, valor);
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro");
        }

    }

    public static Funcionario cadastrarFucnionario(Scanner sc) {

        try {

            System.out.print("Digite o nome: ");
            String nome = sc.nextLine();

            System.out.print("Digite o sobrenome: ");
            String sobrenome = sc.nextLine();

            System.out.print("Digite o cpf: ");
            String cpf = sc.nextLine();

            System.out.println("Digite o salario: ");
            Double salario = sc.nextDouble();

            return new Funcionario(nome, sobrenome, cpf, salario);
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro");
        }

    }

    public static Venda criarVenda(Scanner sc) {
        return null;
    }
}