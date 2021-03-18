package br.com.proven.services;

import br.com.proven.collections.Clientes;
import br.com.proven.entities.Cliente;
import br.com.proven.exceptions.ConversaoException;
import br.com.proven.exceptions.ImpossivelDeletarException;
import br.com.proven.exceptions.ListaVaziaException;
import br.com.proven.exceptions.ValorNegativoException;
import br.com.proven.repositories.ClienteRepository;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ClienteCrud implements ClienteRepository {

    @Override
    public void cadastrarCliente(Scanner sc) {
        try {
            Cliente cliente = criarCliente(sc);
            Clientes.adicionarCliente(cliente);
        } catch (ValorNegativoException | ConversaoException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public Cliente alterarCliente(Scanner sc) {
        Cliente cliente = pegarCliente(sc);

        mostrarCliente(cliente);

        System.out.println("O campo que não deseja editar, apenas pressione enter!");

        System.out.print("Digite o nome: ");
        String nome = sc.nextLine();

        System.out.print("Digite o sobrenome: ");
        String sobrenome = sc.nextLine();

        System.out.print("Digite o cpf: ");
        String cpf = sc.nextLine();

        System.out.print("Digite o limite: ");
        String limite = sc.nextLine();

        Double limiteDouble;
        try {
            limiteDouble = limite.equals("") ? null : Double.parseDouble(limite);
        } catch (Exception e) {
            throw new ConversaoException("Digite um número válido");
        }

        cliente.setNome((nome.equals("") ? cliente.getNome() : nome));
        cliente.setSobrenome((sobrenome.equals("") ? cliente.getNome() : sobrenome));
        cliente.setCpf((cpf.equals("") ? cliente.getNome() : cpf));
        cliente.setLimite((limite.equals("") ? cliente.getLimite() : limiteDouble));

        return cliente;
    }
    @Override
    public Cliente criarCliente(Scanner sc) {

        try {

            System.out.print("Digite o nome: ");
            String nome = sc.nextLine();

            System.out.print("Digite o sobrenome: ");
            String sobrenome = sc.nextLine();

            System.out.print("Digite o cpf: ");
            String cpf = sc.nextLine();

            System.out.print("Digite o limite: ");
            Double limite = sc.nextDouble();

            if (limite < 0) {
                throw new ValorNegativoException("O valor está negativo");
            }

            return new Cliente(nome, sobrenome, cpf, limite);
        } catch (InputMismatchException e) {
            throw new ConversaoException("Os valores são inadequados");
        }
    }
    @Override
    public Cliente deletarCliente(Cliente cliente) {
        if (cliente.getVendasParticipadas().size() > 0) {
            throw new ImpossivelDeletarException("Não é possível deletar o cliente, há vendas associadas a ele, delete " +
                    "primeiro as vendas");
        }
        Clientes.removerCliente(cliente);
        return cliente;
    }
    @Override
    public void mostrarCliente(Cliente cliente) {
        System.out.println("Nome(editavel) | Sobrenome(editavel) | CPF(editavel) | limite(editavel)");
        System.out.println(cliente.mostrarDados());
    }
    @Override
    public void mostrarTodosClientes(List<Cliente> clientes) {
        System.out.println("Nome(editavel) | Sobrenome(editavel) | CPF(editavel) | limite(editavel)");
        clientes.forEach((cliente) -> System.out.println(cliente.mostrarDados()));
    }
    @Override
    public Cliente pegarCliente(Scanner sc) {

        try {

            List<Cliente> clientes = Clientes.getClientes();

            if (clientes.size() == 0) {
                throw new ListaVaziaException("A lista de clientes esta vazia");
            }

            for (int i = 0; i < clientes.size(); i++) {
                System.out.println(i + " - " + clientes.get(i).getNome());
            }

            System.out.print("Digite o indice do cliente: ");
            Integer index = (Integer) sc.nextInt();
            sc.nextLine();

            return clientes.get(index);
        } catch (ListaVaziaException e) {
            throw new ListaVaziaException(e.getMessage());
        }
    }
}
