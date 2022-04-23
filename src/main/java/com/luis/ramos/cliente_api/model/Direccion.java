package com.luis.ramos.cliente_api.model;

import com.luis.ramos.cliente_api.model.dto.DireccionDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Direccion")
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int direccion_id;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Direccion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Direccion() {
    }

    public static Direccion transferir(DireccionDto direccionDto){
        Direccion direccion = new Direccion();
        direccion.setDescripcion(direccionDto.getDescripcion());
        return direccion;
    }

    /*public Direccion(String descripcion, Cliente cliente) {
        this.descripcion = descripcion;
        this.cliente = cliente;
    }*/
}
