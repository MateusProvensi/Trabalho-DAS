package br.com.proven.collections;

import br.com.proven.entities.Produto;

import java.util.ArrayList;
import java.util.List;

public class Produtos {

    private static List<Produto> produtos = new ArrayList<Produto>();

    public static List<Produto> getProdutos() {
        return produtos;
    }

    public static void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public static void removerProduto(Produto produto) {
        produtos.remove(produto);
    }
}
