package com.luis.ramos.cliente_api.model;

import com.luis.ramos.cliente_api.model.dto.ClienteDto;
import com.luis.ramos.cliente_api.model.dto.DireccionDto;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "Cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cliente_id;

    private String nombre;
    private String apellido;
    private int edad;
    private String telefono;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "cliente_id")
    private List<Direccion> direcciones = new ArrayList<>();

    public void agregarDireccion(Direccion direccion){
        direcciones.add(direccion);
    }

    public void quitarDireccion(Direccion direccion){
        direcciones.remove(direccion);
    }

    public static Cliente transferir(ClienteDto clienteDto){
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteDto.getNombre());
        cliente.setApellido(clienteDto.getApellido());
        cliente.setEdad(clienteDto.getEdad());
        cliente.setTelefono(clienteDto.getTelefono());
        cliente.setDirecciones(clienteDto.getDireccionesDto().stream()
                                    .map(Direccion::transferir)
                                    .collect(Collectors.toList()));
        return cliente;
    }



    /*public Cliente(String nombre, String apellido, int edad, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
    }*/
}
