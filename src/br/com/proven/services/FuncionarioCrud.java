package br.com.proven.services;

import br.com.proven.collections.Funcionarios;
import br.com.proven.entities.Funcionario;
import br.com.proven.exceptions.ConversaoException;
import br.com.proven.exceptions.ListaVaziaException;
import br.com.proven.exceptions.ValorNegativoException;
import br.com.proven.repositories.FuncionarioRepository;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FuncionarioCrud implements FuncionarioRepository {

    @Override
    public void cadastrarFuncionario(Scanner sc) {
        try {
            Funcionario funcionario = criarFuncionario(sc);
            Funcionarios.adicionarFuncionario(funcionario);
        } catch (ValorNegativoException | ConversaoException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Funcionario alterarFuncionario(Scanner sc) {
        Funcionario funcionario = pegarFuncionario(sc);

        mostrarFuncionario(funcionario);

        System.out.println("O campo que não deseja editar, apenas pressione enter!");

        System.out.print("Digite o nome: ");
        String nome = sc.nextLine();

        System.out.print("Digite o sobrenome: ");
        String sobrenome = sc.nextLine();

        System.out.print("Digite o cpf: ");
        String cpf = sc.nextLine();

        System.out.print("Digite o salario: ");
        String salario = sc.nextLine();

        Double salarioDouble;
        try {
            salarioDouble = salario.equals("") ? null : Double.parseDouble(salario);
        } catch (Exception e) {
            throw new ConversaoException("Digite um número válido");
        }

        funcionario.setNome((nome.equals("") ? funcionario.getNome() : nome));
        funcionario.setSobrenome((sobrenome.equals("") ? funcionario.getNome() : sobrenome));
        funcionario.setCpf((cpf.equals("") ? funcionario.getNome() : cpf));
        funcionario.setSalario((salario.equals("") ? funcionario.getSalario() : salarioDouble));

        return funcionario;
    }

    @Override
    public Funcionario criarFuncionario(Scanner sc) {

        try {

            System.out.print("Digite o nome: ");
            String nome = sc.nextLine();

            System.out.print("Digite o sobrenome: ");
            String sobrenome = sc.nextLine();

            System.out.print("Digite o cpf: ");
            String cpf = sc.nextLine();

            System.out.println("Digite o salario: ");
            Double salario = sc.nextDouble();

            if (salario < 0) {
                throw new ValorNegativoException("O valor esta negativo");
            }

            return new Funcionario(nome, sobrenome, cpf, salario);
        } catch (InputMismatchException e) {
            throw new ConversaoException("Os valores são inadequados");
        }

    }

    @Override
    public Funcionario deletarFuncionario(Funcionario funcionario) {
        Funcionarios.removerFuncionario(funcionario);
        return funcionario;
    }

    @Override
    public void mostrarFuncionario(Funcionario funcionario) {
        System.out.println("Nome(editavel) | Sobrenome(editavel) | CPF(editavel) | salario(editavel)");
        System.out.println(funcionario.mostrarDados());
    }

    @Override
    public void mostrarTodosFuncionarios(List<Funcionario> funcionarios) {
        System.out.println("Nome(editavel) | Sobrenome(editavel) | CPF(editavel) | salario(editavel)");
        funcionarios.forEach((funcionario) -> System.out.println(funcionario.mostrarDados()));
    }

    @Override
    public Funcionario pegarFuncionario(Scanner sc) {

        try {

            List<Funcionario> funcionarios = Funcionarios.getFuncionarios();

            if (funcionarios.size() == 0) {
                throw new ListaVaziaException("A lista de funcionarios esta vazia");
            }

            for (int i = 0; i < funcionarios.size(); i++) {
                System.out.println(i + " - " + funcionarios.get(i).getNome());
            }

            System.out.print("Digite o indice do funcionario: ");
            Integer index = (Integer) sc.nextInt();
            sc.nextLine();

            return funcionarios.get(index);
        } catch (ListaVaziaException e) {
            throw new ListaVaziaException(e.getMessage());
        }
    }

}
