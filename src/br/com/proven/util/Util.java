package br.com.proven.util;

import br.com.proven.collections.Clientes;
import br.com.proven.collections.Funcionarios;
import br.com.proven.collections.Produtos;
import br.com.proven.collections.Vendas;
import br.com.proven.exceptions.ConversaoException;
import br.com.proven.exceptions.ImpossivelDeletarException;
import br.com.proven.services.*;
import br.com.proven.entities.Cliente;
import br.com.proven.entities.Funcionario;
import br.com.proven.entities.Produto;
import br.com.proven.entities.Venda;
import br.com.proven.exceptions.ListaVaziaException;
import br.com.proven.exceptions.OpcaoIncorretaException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Util {

    private static final FuncionarioCrud funcionarioCrud = new FuncionarioCrud();
    private static final ClienteCrud clienteCrud = new ClienteCrud();
    private static final ProdutoCrud produtoCrud = new ProdutoCrud();
    private static final VendaCrud vendaCrud = new VendaCrud();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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
            continuar = Util.menuPrincipal(sc);
            System.out.println("Pressione enter para continuar");
            sc.nextLine();
        }

        sc.close();
    }

    public static Boolean menuPrincipal(Scanner sc) {
        try {
            System.out.println("1 - Cadastar");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Fazer venda");
            System.out.println("5 - Sair");

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
                    vendaCrud.cadastrarVenda(sc, produtoCrud, clienteCrud, funcionarioCrud);
                    break;
                case "5":
                    return false;
                default:
                    throw new OpcaoIncorretaException("A opção é inexistente");
            }
        } catch (OpcaoIncorretaException | IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public static void menuCadastrar(Scanner sc) {

        try {
            System.out.println("1 - Cliente");
            System.out.println("2 - Produto");
            System.out.println("3 - Funcionario");

            System.out.print("Digite a sua escolha: ");
            String escolha = sc.nextLine();

            switch (escolha) {
                case "1":
                    clienteCrud.cadastrarCliente(sc);
                    break;
                case "2":
                    produtoCrud.cadastrarProduto(sc);
                    break;
                case "3":
                    funcionarioCrud.cadastrarFuncionario(sc);
                    break;
                default:
                    throw new OpcaoIncorretaException("A opção é inexistente");
            }
        } catch (ConversaoException e) {
            System.out.println(e.getMessage());
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
                    Cliente cliente = clienteCrud.pegarCliente(sc);
                    Cliente clienteAlteradoDeletado = escolhaMenuPrincipal.equals("2") ?
                            clienteCrud.alterarCliente(sc) : clienteCrud.deletarCliente(cliente);
                    break;
                case "2":
                    Produto produto = produtoCrud.pegarProduto(sc);
                    Produto produtoAlteradoDeletado = escolhaMenuPrincipal.equals("2") ?
                            produtoCrud.alterarProduto(sc) : produtoCrud.deletarProduto(produto);
                    break;
                case "3":
                    Funcionario funcionario = funcionarioCrud.pegarFuncionario(sc);
                    Funcionario funcionarioAlteradoDeletado = escolhaMenuPrincipal.equals("2") ?
                            funcionarioCrud.alterarFuncionario(sc) : funcionarioCrud.deletarFuncionario(funcionario);
                    break;
                case "4":
                    Venda venda = vendaCrud.pegarVenda(sc);
                    Venda vendaAlteradaDeletada = escolhaMenuPrincipal.equals("2") ?
                            vendaCrud.alterarVenda(sc) : vendaCrud.deletarVenda(venda);
                    break;
                default:
                    throw new OpcaoIncorretaException("A opção é inexistente");
            }
        } catch (ListaVaziaException | ImpossivelDeletarException | ConversaoException e) {
            System.out.println(e.getMessage());
        }
    }

}
