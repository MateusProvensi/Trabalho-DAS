package br.com.proven.services;

import br.com.proven.collections.Produtos;
import br.com.proven.collections.Vendas;
import br.com.proven.entities.Produto;
import br.com.proven.exceptions.ConversaoException;
import br.com.proven.exceptions.ImpossivelDeletarException;
import br.com.proven.exceptions.ListaVaziaException;
import br.com.proven.exceptions.ValorNegativoException;
import br.com.proven.repositories.ProdutoRepository;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class ProdutoCrud implements ProdutoRepository {
    @Override
    public void cadastrarProduto(Scanner sc) {
        try {
            Produto produto = criarProduto(sc);
            Produtos.adicionarProduto(produto);
        } catch (ValorNegativoException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Produto alterarProduto(Scanner sc) {
        Produto produto = pegarProduto(sc);

        mostrarProduto(produto);

        System.out.println("O campo que não deseja editar, apenas pressione enter!");

        System.out.print("Digite a descrição: ");
        String descricao = sc.nextLine();

        System.out.print("Digite a unidade de medida: ");
        String unidadeMedida = sc.nextLine();

        System.out.print("Digite o valor do produto: ");
        String valor = sc.nextLine();

        Double valorDouble;
        try {
            valorDouble = valor.equals("") ? null : Double.parseDouble(valor);
        } catch (Exception e) {
            throw new ConversaoException("Digite um número válido");
        }

        produto.setDescricao((descricao.equals("") ? produto.getDescricao() : descricao));
        produto.setUnidadeMedida((unidadeMedida.equals("") ? produto.getUnidadeMedida() : unidadeMedida));
        produto.setValor((valor.equals("") ? produto.getValor() : valorDouble));

        return produto;
    }

    @Override
    public Produto criarProduto(Scanner sc) {
        try {

            System.out.print("Digite a descrição: ");
            String descricao = sc.nextLine();

            System.out.print("Digite a unidade de medida: ");
            String unidadeMedida = sc.nextLine();

            System.out.print("Digite o valor: ");
            Double valor = sc.nextDouble();

            if (valor < 0) {
                throw new ValorNegativoException("O valor está negativo");
            }

            return new Produto(descricao, unidadeMedida, valor);
        } catch (InputMismatchException e) {
            throw new ConversaoException("Os valores são inadequados");
        }
    }

    @Override
    public Produto deletarProduto(Produto produto) {

        AtomicReference<Boolean> temDependencias = new AtomicReference<>(false);

        Vendas.getVendas().forEach((venda) -> venda.getProdutosDaVenda().forEach((produtoParam) -> {
            if (produtoParam == produto) {
                temDependencias.set(true);
            }
        }));

        if (temDependencias.get()) {
            throw new ImpossivelDeletarException("Não é possível deletar o produto, há vendas associadas a ele, " +
                    "delete primeiro as vendas");
        }

        Produtos.removerProduto(produto);
        return produto;
    }

    @Override
    public void mostrarProduto(Produto produto) {
        System.out.println("Descricao(editavel) | Unidade de medida(editavel) | valor(editalvel)");
        System.out.println(produto.mostrarDados());
    }

    @Override
    public void mostrarTodosProdutos(List<Produto> produtos) {
        System.out.println("Descricao(editavel) | Unidade de medida(editavel) | valor(editalvel)");
        produtos.forEach((produto) -> System.out.println(produto.mostrarDados()));
    }

    @Override
    public Produto pegarProduto(Scanner sc) {

        List<Produto> produtos = Produtos.getProdutos();

        if (produtos.size() == 0) {
            throw new ListaVaziaException("A lista de produtos está vazia");
        }

        for (int i = 0; i < produtos.size(); i++) {
            System.out.println(i + " - " + produtos.get(i).getDescricao());
        }

        System.out.print("Digite o indice do produto: ");
        Integer index = (Integer) sc.nextInt();
        sc.nextLine();

        return produtos.get(index);
    }


}
