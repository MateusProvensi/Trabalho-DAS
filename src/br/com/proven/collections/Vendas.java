package br.com.proven.collections;

import br.com.proven.entities.Venda;

import java.util.ArrayList;
import java.util.List;

public class Vendas {

    private static List<Venda> vendas = new ArrayList<Venda>();

    public static List<Venda> getVendas() {
        return vendas;
    }

    public static void adicionarVenda(Venda venda) {
        vendas.add(venda);
    }

    public static void removerVenda(Venda venda) {
        vendas.remove(venda);
    }
}
