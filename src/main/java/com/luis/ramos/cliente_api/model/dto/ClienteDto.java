package com.luis.ramos.cliente_api.model.dto;

import com.luis.ramos.cliente_api.model.Cliente;
import com.luis.ramos.cliente_api.model.Direccion;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ClienteDto {

    private Long cliente_id;

    private String nombre;
    private String apellido;
    private int edad;
    private String telefono;
    private List<DireccionDto> direccionesDto = new ArrayList<>();

    public static ClienteDto transferir(Cliente cliente){
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setCliente_id(cliente.getCliente_id());
        clienteDto.setNombre(cliente.getNombre());
        clienteDto.setApellido(cliente.getApellido());
        clienteDto.setEdad(cliente.getEdad());
        clienteDto.setTelefono(cliente.getTelefono());
        clienteDto.setDireccionesDto(cliente.getDirecciones().stream()
                                                            .map(DireccionDto::transferir)
                                                            .collect(Collectors.toList()));
        return clienteDto;
    }
}
