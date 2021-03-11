package br.com.proven.crud;

import br.com.proven.entities.Cliente;
import br.com.proven.entities.Funcionario;
import br.com.proven.entities.Produto;
import br.com.proven.entities.Venda;
import br.com.proven.exceptions.ConversaoException;

import java.util.Scanner;

public class Alterar {

    public static Cliente alterarCliente(Scanner sc) {
            Cliente cliente = Pegar.pegarCliente(sc);

            Mostrar.mostrarCliente(cliente);

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
            } catch (Exception e){
                throw new ConversaoException("Digite um número válido");
            }

            cliente.setNome((nome.equals("") ? cliente.getNome() : nome));
            cliente.setSobrenome((sobrenome.equals("") ? cliente.getNome() : sobrenome));
            cliente.setCpf((cpf.equals("") ? cliente.getNome() : cpf));
            cliente.setLimite((limite.equals("") ? cliente.getLimite() : limiteDouble));

            return cliente;
    }

    public static Produto alterarProduto(Scanner sc) {
        Produto produto = Pegar.pegarProduto(sc);

        return null;
    }

    public static Funcionario alterarFuncionario(Scanner sc) {
        Funcionario funcionario = Pegar.pegarFuncionario(sc);

        return null;
    }

    public static Venda alterarVenda(Scanner sc) {
        Venda venda = Pegar.pegarVenda(sc);

        return null;
    }
}
