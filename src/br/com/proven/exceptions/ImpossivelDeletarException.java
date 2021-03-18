package br.com.proven.exceptions;

public class ImpossivelDeletarException extends RuntimeException{

    public ImpossivelDeletarException(String mensagem) {
        super(mensagem);
    }

}
