package com.luis.ramos.cliente_api.model.dto;

import com.luis.ramos.cliente_api.model.Direccion;
import lombok.Data;

@Data
public class DireccionDto {
    private int direccion_id;
    private String descripcion;

    public static DireccionDto transferir(Direccion direccion){
        DireccionDto direccionDto = new DireccionDto();
        direccionDto.setDireccion_id(direccion.getDireccion_id());
        direccionDto.setDescripcion(direccion.getDescripcion());
        return direccionDto;
    }
}
