package br.com.proven.exceptions;

public class ConversaoException extends RuntimeException{

    String mensagem;

    public ConversaoException(String mensagem) {
        super(mensagem);
    }

}
