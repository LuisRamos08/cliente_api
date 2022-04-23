package com.luis.ramos.cliente_api.service;

import com.luis.ramos.cliente_api.model.Direccion;
import com.luis.ramos.cliente_api.model.exception.DireccionNotFoundException;
import com.luis.ramos.cliente_api.repository.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DireccionService {

    private final DireccionRepository direccionRepository;

    @Autowired
    public DireccionService(DireccionRepository direccionRepository) {
        this.direccionRepository = direccionRepository;
    }

    public Direccion guardarDireccion(Direccion direccion){
        return direccionRepository.save(direccion);
    }

    public List<Direccion> buscarDirecciones(){
        return StreamSupport
                .stream(direccionRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    public Direccion buscarDireccion(Long id){
        return direccionRepository.findById(id).orElseThrow(() ->
                new DireccionNotFoundException(id));
    }

    public Direccion eliminarDireccion(Long id){
        Direccion direccion = this.buscarDireccion(id);
        direccionRepository.delete(direccion);
        return direccion;
    }

    @Transactional
    public Direccion modificarDireccion(Long id, Direccion direccion){
        Direccion direccionToEdit = this.buscarDireccion(id);
        direccionToEdit.setDescripcion(direccion.getDescripcion());
        return direccionToEdit;
    }
}
