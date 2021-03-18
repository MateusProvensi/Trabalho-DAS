package br.com.proven.repositories;

import br.com.proven.collections.Funcionarios;
import br.com.proven.entities.Funcionario;
import br.com.proven.exceptions.ConversaoException;
import br.com.proven.exceptions.ListaVaziaException;
import br.com.proven.exceptions.ValorNegativoException;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public interface FuncionarioRepository {
    void cadastrarFuncionario(Scanner sc);

    Funcionario alterarFuncionario(Scanner sc);

    Funcionario criarFuncionario(Scanner sc);

    void mostrarFuncionario(Funcionario funcionario);

    void mostrarTodosFuncionarios(List<Funcionario> funcionarios);

    Funcionario deletarFuncionario(Funcionario funcionario);

    Funcionario pegarFuncionario(Scanner sc);
}
