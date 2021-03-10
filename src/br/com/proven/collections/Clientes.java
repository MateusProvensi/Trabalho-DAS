package br.com.proven.collections;

import br.com.proven.entities.Cliente;

import java.util.ArrayList;
import java.util.List;

public class Clientes {

    private static List<Cliente> clientes = new ArrayList<Cliente>();

    public static List<Cliente> getClientes() {
        return clientes;
    }

    public static void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public static void removerCliente(Cliente cliente) {
        clientes.remove(cliente);
    }
}
