package br.com.proven.application;

import br.com.proven.entities.Cliente;
import br.com.proven.entities.Funcionario;
import br.com.proven.entities.Produto;
import br.com.proven.entities.Venda;

public class Application {

    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Jaspion", "Power", "56978912341", 290.0);
        Cliente cliente2 = new Cliente("Pastor", "Hagi", "56978912341", 300.0);

        Funcionario funcionario1 = new Funcionario("João", "Huguinaldo", "123456789456", 1500.00);
        Funcionario funcionario2 = new Funcionario("Kii", "Kelli", "123456789456", 1500.00);

        Produto produto1 = new Produto("Coquinha", "UN", 5.00);
        Produto produto2 = new Produto("Leite", "LT", 2.00);
        Produto produto3 = new Produto("Pão", "KG", 11.00);

        Venda venda1 = new Venda(10.0, 0.0, cliente1, funcionario1);
        venda1.adicionarProduto(produto1);
        venda1.adicionarProduto(produto1);
        cliente1.adicionarVenda(venda1);
        funcionario1.adicionarVendas(venda1);

        Venda venda2 = new Venda(11.0, 2.00, cliente2, funcionario2);
        venda2.adicionarProduto(produto2);
        venda2.adicionarProduto(produto3);
        cliente2.adicionarVenda(venda2);
        funcionario2.adicionarVendas(venda2);
        System.out.println(cliente1.getVendasParticipadas());
        System.out.println(cliente1);
        venda1.setCliente(cliente2);
        cliente1.removerVenda(venda1);

        System.out.println(cliente1.getVendasParticipadas());
    }
}
