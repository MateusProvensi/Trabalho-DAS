package br.com.proven.exceptions;

public class ValorNegativoException extends RuntimeException{

    private String mensagem;

    public ValorNegativoException(String mensagem) {
        super(mensagem);
    }

}
