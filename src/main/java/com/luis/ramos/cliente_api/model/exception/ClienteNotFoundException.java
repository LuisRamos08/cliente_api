package com.luis.ramos.cliente_api.model.exception;

import java.text.MessageFormat;

public class ClienteNotFoundException extends RuntimeException{

    public ClienteNotFoundException(final Long id){
        super(MessageFormat.format("No se pudo encontrar el Cliente con el id: {0}", id));
    }
}
