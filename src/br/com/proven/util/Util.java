package br.com.proven.util;

import br.com.proven.crud.*;
import br.com.proven.entities.Cliente;
import br.com.proven.entities.Funcionario;
import br.com.proven.entities.Produto;
import br.com.proven.entities.Venda;
import br.com.proven.exceptions.ConversaoException;
import br.com.proven.exceptions.ListaVaziaException;
import br.com.proven.exceptions.OpcaoIncorretaException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Util {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(new Cliente("Jaspion", "Silva", "123484", 15.00));
        clientes.add(new Cliente("FA", "Silva", "123484", 15.00));
        clientes.add(new Cliente("JasFEpion", "Silva", "123484", 15.00));

        Funcionario funcionario = new Funcionario("haba", "Justo", "456132", 450.0);

        Produto produto1 = new Produto("Coca", "LT", 5.00);
        Produto produto2 = new Produto("Pepsi", "LT", 4.00);
        Produto produto3 = new Produto("Hamburguer", "UN", 9.00);

        Venda venda = new Venda(0.0, clientes.get(0), funcionario);
        venda.adicionarProduto(produto1);
        venda.adicionarProduto(produto2);
        venda.adicionarProduto(produto1);
        venda.adicionarProduto(produto3);

        System.out.println(venda.mostrarDados());

        sc.close();
    }

    public static void menuPrincipal(Scanner sc) {
        try {
            System.out.println("1 - Cadastar");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Fazer venda");

            System.out.print("Digite a sua escolha: ");
            String escolha = sc.nextLine();

            switch (escolha) {
                case "1":
                    menuCadastrar(sc);
                    break;
                case "2":
                case "3":
                    AlterarEDeletar(sc, escolha);
                    break;
                case "4":
                    Cadastro.cadastrarVenda(sc);
                    break;
                default:
                    throw new OpcaoIncorretaException("A opção é inexistente");
            }
        } catch (OpcaoIncorretaException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void menuCadastrar(Scanner sc) {

        System.out.println("1 - Cliente");
        System.out.println("2 - Produto");
        System.out.println("3 - Funcionario");

        System.out.print("Digite a sua escolha: ");
        String escolha = sc.nextLine();

        switch (escolha) {
            case "1":
                Cadastro.cadastrarCliente(sc);
                break;
            case "2":
                Cadastro.cadastrarProduto(sc);
                break;
            case "3":
                Cadastro.cadastrarFuncionario(sc);
                break;
            default:
                throw new OpcaoIncorretaException("A opção é inexistente");
        }

    }

    public static String menuAlterarDeletar(Scanner sc) {
        System.out.println("1 - Cliente");
        System.out.println("2 - Produto");
        System.out.println("3 - Funcionario");
        System.out.println("4 - Venda");

        System.out.print("Digite a sua escolha: ");
        String escolha = sc.nextLine();

        return escolha;
    }

    public static void AlterarEDeletar(Scanner sc, String escolhaMenuPrincipal) {
        try {
            String escolha = menuAlterarDeletar(sc);

            switch (escolha) {
                case "1":
                    Cliente cliente = Pegar.pegarCliente(sc);
                    Cliente clienteAlteradoDeletado = escolhaMenuPrincipal.equals("2") ?
                            Alterar.alterarCliente(sc) : Deletar.deletarCliente(cliente);
                    break;
                case "2":
                    Produto produto = Pegar.pegarProduto(sc);
                    Produto produtoAlteradoDeletado = escolhaMenuPrincipal.equals("2") ?
                            Alterar.alterarProduto(sc) : Deletar.deletarProduto(produto);
                    break;
                case "3":
                    Funcionario funcionario = Pegar.pegarFuncionario(sc);
                    Funcionario funcionarioAlteradoDeletado = escolhaMenuPrincipal.equals("2") ?
                            Alterar.alterarFuncionario(sc) : Deletar.deletarFuncionario(funcionario);
                    break;
                case "4":
                    Venda venda = Pegar.pegarVenda(sc);
                    Venda vendaAlteradaDeletada = escolhaMenuPrincipal.equals("2") ?
                            Alterar.alterarVenda(sc) : Deletar.deletarVenda(venda);
                    break;
                default:
                    throw new OpcaoIncorretaException("A opção é inexistente");
            }
        } catch (ListaVaziaException e) {
            System.out.println(e.getMessage());
        }
    }

}
