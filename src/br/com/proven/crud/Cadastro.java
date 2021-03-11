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
import br.com.proven.exceptions.ValorNegativoException;

import java.util.List;
import java.util.Scanner;

public class Cadastro {


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

    public static Funcionario cadastrarFuncionario(Scanner sc) {

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

        try {
            System.out.println("Digite o desconto: ");
            Double desconto = (Double) sc.nextDouble();

            if (desconto < 0.0) {
                throw new ValorNegativoException("O valor está negativo");
            }

            Cliente cliente = Pegar.pegarCliente(sc);
            Funcionario funcionario = Pegar.pegarFuncionario(sc);

            Venda vendaAtual = new Venda(desconto, cliente, funcionario);

            Pegar.pegarProdutoVenda(sc, vendaAtual);

            return vendaAtual;
        } catch (ValorNegativoException e) {
            throw new ValorNegativoException(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
