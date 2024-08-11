package br.com.ifpe.oxefood.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class ClienteNumeroException extends RuntimeException {

    public static final String MSG_SEM_DDD = "Não é permitido inserir cliente com um telefone que não tenha o prefixo 81.";

    public ClienteNumeroException(String msg) {

	super(String.format(msg));
    }
}

