package br.com.proven.exceptions;

public class OpcaoIncorretaException extends RuntimeException{

    String mensagem;

    public OpcaoIncorretaException(String mensagem) {
        super(mensagem);
    }

}
