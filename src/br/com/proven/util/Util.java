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

import java.util.Scanner;

public class Util {

    private final FuncionarioCrud funcionarioCrud;
    private final ClienteCrud clienteCrud;
    private final ProdutoCrud produtoCrud;
    private final VendaCrud vendaCrud;

    public Util() {
        this.funcionarioCrud = new FuncionarioCrud();
        this.clienteCrud = new ClienteCrud();
        this.produtoCrud = new ProdutoCrud();
        this.vendaCrud = new VendaCrud();
    }

    public Boolean menuPrincipal(Scanner sc) {
        try {
            System.out.println("1 - Cadastar");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Fazer venda");
            System.out.println("5 - Mostrar dados");
            System.out.println("6 - Sair");

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
                    //System.out.println("Ainda não foi implementada");
                    lerDados(sc);
                    break;
                case "6":
                    return false;
                default:
                    throw new OpcaoIncorretaException("A opção é inexistente");
            }
        } catch (OpcaoIncorretaException | IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public void menuCadastrar(Scanner sc) {

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

    public String menuAlterarDeletarLer(Scanner sc) {
        System.out.println("1 - Cliente");
        System.out.println("2 - Produto");
        System.out.println("3 - Funcionario");
        System.out.println("4 - Venda");

        System.out.print("Digite a sua escolha: ");
        String escolha = sc.nextLine();

        return escolha;
    }

    public void lerDados(Scanner sc) {
        String escolha = menuAlterarDeletarLer(sc);
        switch (escolha) {
            case "1":
                clienteCrud.mostrarTodosClientes(Clientes.getClientes());
                break;
            case "2":
                produtoCrud.mostrarTodosProdutos(Produtos.getProdutos());
                break;
            case "3":
                funcionarioCrud.mostrarTodosFuncionarios(Funcionarios.getFuncionarios());
                break;
            case "4":
                vendaCrud.mostrarTodasVendas(Vendas.getVendas());
                break;
            default:
                throw new OpcaoIncorretaException("A opção é inexistente");
        }
    }

    public void AlterarEDeletar(Scanner sc, String escolhaMenuPrincipal) {
        try {
            String escolha = menuAlterarDeletarLer(sc);

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
