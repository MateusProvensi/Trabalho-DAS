package br.com.proven.application;

import br.com.proven.cadastros.Cadastro;
import br.com.proven.collections.Clientes;
import br.com.proven.entities.Cliente;
import br.com.proven.entities.Funcionario;
import br.com.proven.entities.Produto;
import br.com.proven.entities.Venda;
import br.com.proven.util.Util;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*Clientes.adicionarCliente(new Cliente("Jaspion", "Silva", "123484", 15.00));
        Clientes.adicionarCliente(new Cliente("FA", "Silva", "123484", 15.00));
        Clientes.adicionarCliente(new Cliente("JasFEpion", "Silva", "123484", 15.00));*/
        Cadastro.pegarCliente(sc);

    }
}
