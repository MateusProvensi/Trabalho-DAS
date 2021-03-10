package br.com.proven.exceptions;

public class ListaVaziaException extends RuntimeException{

    String mensagem;

    public ListaVaziaException(String mensagem) {
        super(mensagem);
    }
}
