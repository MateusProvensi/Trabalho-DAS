package br.com.proven.crud;

import br.com.proven.entities.Cliente;
import br.com.proven.entities.Funcionario;
import br.com.proven.entities.Produto;
import br.com.proven.entities.Venda;
import br.com.proven.exceptions.ConversaoException;
import br.com.proven.exceptions.ListaVaziaException;
import br.com.proven.exceptions.ValorNegativoException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Criar {


    public static Cliente criarCliente(Scanner sc) {

        try {

            System.out.print("Digite o nome: ");
            String nome = sc.nextLine();

            System.out.print("Digite o sobrenome: ");
            String sobrenome = sc.nextLine();

            System.out.print("Digite o cpf: ");
            String cpf = sc.nextLine();

            System.out.print("Digite o limite: ");
            Double limite = sc.nextDouble();

            if (limite < 0) {
                throw new ValorNegativoException("O valor está negativo");
            }

            return new Cliente(nome, sobrenome, cpf, limite);
        } catch (InputMismatchException e) {
            throw new ConversaoException("Os valores são inadequados");
        }
    }

    public static Produto criarProduto(Scanner sc) {
        try {

            System.out.println("Digite a descrição: ");
            String descricao = sc.nextLine();

            System.out.println("Digite a unidade de medida: ");
            String unidadeMedida = sc.nextLine();

            System.out.println("Digite o valor: ");
            Double valor = sc.nextDouble();

            if (valor < 0) {
                throw new ValorNegativoException("O valor está negativo");
            }

            return new Produto(descricao, unidadeMedida, valor);
        } catch (InputMismatchException e) {
            throw new ConversaoException("Os valores são inadequados");
        }
    }

    public static Funcionario criarFuncionario(Scanner sc) {

        try {

            System.out.print("Digite o nome: ");
            String nome = sc.nextLine();

            System.out.print("Digite o sobrenome: ");
            String sobrenome = sc.nextLine();

            System.out.print("Digite o cpf: ");
            String cpf = sc.nextLine();

            System.out.println("Digite o salario: ");
            Double salario = sc.nextDouble();

            if (salario < 0) {
                throw new ValorNegativoException("O valor esta negativo");
            }

            return new Funcionario(nome, sobrenome, cpf, salario);
        } catch (InputMismatchException e) {
            throw new ConversaoException("Os valores são inadequados");
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
        } catch (ListaVaziaException e) {
            throw new ListaVaziaException(e.getMessage());
        } catch (InputMismatchException e) {
            throw new ConversaoException("Os valores são inadequados");
        }
    }
}
