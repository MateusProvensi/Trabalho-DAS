package br.com.proven.crud;

import br.com.proven.collections.Clientes;
import br.com.proven.collections.Funcionarios;
import br.com.proven.collections.Produtos;
import br.com.proven.collections.Vendas;
import br.com.proven.entities.Cliente;
import br.com.proven.entities.Funcionario;
import br.com.proven.entities.Produto;
import br.com.proven.entities.Venda;

public class Deletar {

    public static Cliente deletarCliente(Cliente cliente) {
        Clientes.removerCliente(cliente);
        return cliente;
    }

    public static Produto deletarProduto(Produto produto) {
        Produtos.removerProduto(produto);
        return produto;
    }

    public static Funcionario deletarFuncionario(Funcionario funcionario) {
        Funcionarios.removerFuncionario(funcionario);
        return funcionario;
    }

    public static Venda deletarVenda(Venda venda) {
        Vendas.removerVenda(venda);
        return venda;
    }

}
