package br.com.proven.services;

import br.com.proven.collections.Vendas;
import br.com.proven.entities.Cliente;
import br.com.proven.entities.Funcionario;
import br.com.proven.entities.Produto;
import br.com.proven.entities.Venda;
import br.com.proven.exceptions.ConversaoException;
import br.com.proven.exceptions.ListaVaziaException;
import br.com.proven.exceptions.ValorNegativoException;
import br.com.proven.repositories.VendaRepository;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class VendaCrud implements VendaRepository {

    @Override
    public void cadastrarVenda(Scanner sc, ProdutoCrud produtoCrud, ClienteCrud clienteCrud,
                               FuncionarioCrud funcionarioCrud) {
        try {
            Venda venda = criarVenda(sc, produtoCrud, clienteCrud, funcionarioCrud);
            Vendas.adicionarVenda(venda);
        } catch (ValorNegativoException | ListaVaziaException | ConversaoException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Venda alterarVenda(Scanner sc) {
        Venda venda = pegarVenda(sc);

        return null;
    }

    @Override
    public Venda criarVenda(Scanner sc, ProdutoCrud produtoCrud, ClienteCrud clienteCrud,
                            FuncionarioCrud funcionarioCrud) {

        try {
            System.out.println("Digite o desconto: ");
            Double desconto = (Double) sc.nextDouble();
            sc.nextLine();

            if (desconto < 0.0) {
                throw new ValorNegativoException("O valor está negativo");
            }

            System.out.println("Escolha o cliente da venda");
            Cliente cliente = clienteCrud.pegarCliente(sc);
            System.out.println("Escolha o funcionario da venda");
            Funcionario funcionario = funcionarioCrud.pegarFuncionario(sc);

            Venda vendaAtual = new Venda(desconto, cliente, funcionario);

            System.out.println("Produtos da venda");
            pegarProdutoVenda(sc, vendaAtual, produtoCrud);

            return vendaAtual;
        } catch (ListaVaziaException e) {
            throw new ListaVaziaException(e.getMessage());
        } catch (InputMismatchException e) {
            throw new ConversaoException("Os valores são inadequados");
        }
    }

    @Override
    public Venda deletarVenda(Venda venda) {
        Cliente cliente = venda.getCliente();
        Funcionario funcionario = venda.getFuncionario();
        cliente.removerVenda(venda);
        funcionario.removerVenda(venda);

        Vendas.removerVenda(venda);
        return venda;
    }

    @Override
    public void mostrarVenda(Venda venda) {
        System.out.println("SubTotal(acrecentavel) | Total(acrecentavel) | Desconto(editavel) | Cliente(edital) | " +
                "Funcionario(editavel) | Produtos(acrecentavel) | ");
        System.out.println(venda.mostrarDados());
    }

    @Override
    public void mostrarTodasVendas(List<Venda> vendas) {
        System.out.println("SubTotal(acrecentavel) | Total(acrecentavel) | Desconto(editavel) | Cliente(edital) | " +
                "Funcionario(editavel) | Produtos(acrecentavel) | ");
        vendas.forEach((venda) -> System.out.println(venda.mostrarDados()));
    }

    @Override
    public Venda pegarVenda(Scanner sc) {

        List<Venda> vendas = Vendas.getVendas();

        if (vendas.size() == 0) {
            throw new ListaVaziaException("A lista de vendas esta vazia");
        }

        System.out.println("SubTotal(acrecentavel) | Total(acrecentavel) | Desconto(editavel) | Cliente(edital) | " +
                "Funcionario(editavel) | Produtos(acrecentavel) | ");
        for (int i = 0; i < vendas.size(); i++) {
            System.out.println(i + " - " + vendas.get(i).mostrarDados());
        }

        System.out.print("Digite o indice do produto: ");
        Integer index = (Integer) sc.nextInt();
        sc.nextLine();

        return vendas.get(index);

    }

    @Override
    public void pegarProdutoVenda(Scanner sc, Venda venda, ProdutoCrud produtoCrud) {

        while (true) {
            System.out.println("1 - Adicionar mais");
            System.out.println("2 - Finalizar");

            System.out.print("Digite a sua escolha: ");
            String escolha = sc.nextLine();

            if (escolha.equals("2")) {
                if (venda.getProdutosDaVenda().size() == 0) {
                    System.out.println("A venda não pode estar sem produtos");
                    continue;
                }
                break;
            } else if (!escolha.equals("1")) {
                System.out.println("Opção incorreta!");
            }
            Produto produto = produtoCrud.pegarProduto(sc);
            venda.adicionarProduto(produto);
        }

    }
}
