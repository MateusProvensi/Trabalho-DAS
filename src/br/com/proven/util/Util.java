package br.com.proven.util;

import br.com.proven.collections.Clientes;
import br.com.proven.crud.Cadastro;
import br.com.proven.entities.Cliente;
import br.com.proven.entities.Produto;
import br.com.proven.entities.Venda;

import java.util.Scanner;

public class Util {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String escolha = menuPrincipal(sc);
    }

    public static String menuPrincipal(Scanner sc) {
        System.out.println("1 - Cadastar");
        System.out.println("2 - Alterar");
        System.out.println("3 - Excluir");
        System.out.println("4 - Fazer venda");

        System.out.print("Digite a sua escolha: ");
        String escolha = sc.nextLine();

        return escolha;
    }

    public static String menuCadastrar(Scanner sc) {
        System.out.println("1 - Cliente");
        System.out.println("2 - Produto");
        System.out.println("3 - Funcionario");

        System.out.print("Digite a sua escolha: ");
        String escolha = sc.nextLine();
        return escolha;
    }

    public static String menuAlterarEDeletar(Scanner sc) {
        System.out.println("1 - Cliente");
        System.out.println("2 - Produto");
        System.out.println("3 - Funcionario");
        System.out.println("4 - Venda");

        System.out.print("Digite a sua escolha: ");
        String escolha = sc.nextLine();
        return escolha;
    }

}
