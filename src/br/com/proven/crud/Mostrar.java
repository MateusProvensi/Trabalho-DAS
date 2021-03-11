package br.com.proven.crud;

import br.com.proven.collections.Clientes;
import br.com.proven.entities.Cliente;

import java.util.List;

public class Mostrar {

    public static void mostrarCliente(Cliente cliente) {
        System.out.println("Nome(editavel) | Sobrenome(editavel) | CPF(editavel) | limite(editavel)");
        System.out.println(cliente.mostrarDados());
    }

    public static void mostrarTodosClientes(List<Cliente> clientes) {
        System.out.println("Nome(editavel) | Sobrenome(editavel) | CPF(editavel) | limite(editavel)");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.mostrarDados());
        }
    }

}
