package br.com.proven.application;

import br.com.proven.exceptions.OpcaoIncorretaException;
import br.com.proven.util.Util;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Util.menuPrincipal(sc);

        sc.close();
    }
}
