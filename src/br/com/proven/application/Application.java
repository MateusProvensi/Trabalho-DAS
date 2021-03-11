package br.com.proven.application;

import br.com.proven.crud.Cadastro;

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
