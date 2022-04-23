package com.luis.ramos.cliente_api.model.exception;

import java.text.MessageFormat;

public class DireccionNotFoundException extends RuntimeException{

    public DireccionNotFoundException(final Long id){
        super(MessageFormat.format("No se pudo encontrar la Direccion con el id: {0}", id));
    }
}
