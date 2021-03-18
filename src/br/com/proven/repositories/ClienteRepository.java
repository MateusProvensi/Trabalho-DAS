package br.com.proven.repositories;

import br.com.proven.collections.Clientes;
import br.com.proven.entities.Cliente;
import br.com.proven.exceptions.ConversaoException;
import br.com.proven.exceptions.ImpossivelDeletarException;
import br.com.proven.exceptions.ListaVaziaException;
import br.com.proven.exceptions.ValorNegativoException;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public interface ClienteRepository {

    void cadastrarCliente(Scanner sc);

    Cliente alterarCliente(Scanner sc);

    Cliente criarCliente(Scanner sc);

    Cliente deletarCliente(Cliente cliente);

    void mostrarCliente(Cliente cliente);

    void mostrarTodosClientes(List<Cliente> clientes);

    Cliente pegarCliente(Scanner sc);
}
