package br.com.proven.repositories;

import br.com.proven.collections.Vendas;
import br.com.proven.entities.Cliente;
import br.com.proven.entities.Funcionario;
import br.com.proven.entities.Produto;
import br.com.proven.entities.Venda;
import br.com.proven.exceptions.ConversaoException;
import br.com.proven.exceptions.ListaVaziaException;
import br.com.proven.exceptions.ValorNegativoException;
import br.com.proven.services.ClienteCrud;
import br.com.proven.services.FuncionarioCrud;
import br.com.proven.services.ProdutoCrud;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public interface VendaRepository {
    void cadastrarVenda(Scanner sc, ProdutoCrud produtoCrud, ClienteCrud clienteCrud,
                        FuncionarioCrud funcionarioCrud);

    Venda alterarVenda(Scanner sc);

    Venda criarVenda(Scanner sc, ProdutoCrud produtoCrud, ClienteCrud clienteCrud,
                     FuncionarioCrud funcionarioCrud);

    Venda deletarVenda(Venda venda);

    void mostrarVenda(Venda venda);

    void mostrarTodasVendas(List<Venda> vendas);

    Venda pegarVenda(Scanner sc);

    void pegarProdutoVenda(Scanner sc, Venda venda, ProdutoCrud produtoCrud);

}
