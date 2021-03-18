package br.com.proven.repositories;

import br.com.proven.collections.Produtos;
import br.com.proven.collections.Vendas;
import br.com.proven.entities.Produto;
import br.com.proven.exceptions.ConversaoException;
import br.com.proven.exceptions.ImpossivelDeletarException;
import br.com.proven.exceptions.ListaVaziaException;
import br.com.proven.exceptions.ValorNegativoException;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public interface ProdutoRepository {
    void cadastrarProduto(Scanner sc);

    Produto alterarProduto(Scanner sc);

    Produto criarProduto(Scanner sc);

    Produto deletarProduto(Produto produto);

    void mostrarProduto(Produto produto);

    void mostrarTodosProdutos(List<Produto> produtos);

    Produto pegarProduto(Scanner sc);
}
