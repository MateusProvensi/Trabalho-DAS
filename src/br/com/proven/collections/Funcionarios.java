package br.com.proven.collections;

import br.com.proven.entities.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class Funcionarios {

    private static List<Funcionario> funcionarios = new ArrayList<Funcionario>();

    public static List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public static void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public static void removerFuncionario(Funcionario funcionario) {
        funcionarios.remove(funcionario);
    }
}
