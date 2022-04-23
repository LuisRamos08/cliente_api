package com.luis.ramos.cliente_api.model.exception;

import java.text.MessageFormat;

public class DireccionIsAlreadyAssignedException extends RuntimeException{
    public DireccionIsAlreadyAssignedException(final Long direccionId, final Long clienteID){
        super(MessageFormat.format("La Direccion: {0} ya pertenece al Cliente con el id: {1}", direccionId,clienteID));
    }
}
