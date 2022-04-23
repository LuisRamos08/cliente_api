package com.luis.ramos.cliente_api.controller;

import com.luis.ramos.cliente_api.model.Direccion;
import com.luis.ramos.cliente_api.model.dto.DireccionDto;
import com.luis.ramos.cliente_api.service.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/direcciones")
public class DireccionController {

    private final DireccionService direccionService;

    @Autowired
    public DireccionController(DireccionService direccionService) {
        this.direccionService = direccionService;
    }

    @PostMapping(value = "/guardar")
    public ResponseEntity<DireccionDto> guardarDireccion(@RequestBody final DireccionDto direccionDto){
        Direccion direccion = direccionService.guardarDireccion(Direccion.transferir(direccionDto));
        return new ResponseEntity<>(DireccionDto.transferir(direccion), HttpStatus.OK);
    }

    @GetMapping(value = "/buscarTodas")
    public ResponseEntity<List<DireccionDto>> buscarDirecciones(){
        List<Direccion> direcciones = direccionService.buscarDirecciones();
        List<DireccionDto> direccionesDto = direcciones.stream().map(DireccionDto::transferir).collect(Collectors.toList());
        return new ResponseEntity<>(direccionesDto, HttpStatus.OK);
    }

    @GetMapping(value = "/buscar/{id}")
    public ResponseEntity<DireccionDto> buscarDireccion(@PathVariable final Long id){
        Direccion direccion = direccionService.buscarDireccion(id);
        return new ResponseEntity<>(DireccionDto.transferir(direccion), HttpStatus.OK);
    }

    @DeleteMapping(value = "/eliminar/{id}")
    public ResponseEntity<DireccionDto> eliminarDireccion(@PathVariable final Long id){
        Direccion direccion = direccionService.eliminarDireccion(id);
        return new ResponseEntity<>(DireccionDto.transferir(direccion), HttpStatus.OK);
    }

    @PutMapping(value = "/modificar/{id}")
    public ResponseEntity<DireccionDto> modificarDireccion(@PathVariable final Long id,
                                                           @RequestBody final DireccionDto direccionDto){
        Direccion direccionModificada = direccionService.modificarDireccion(id,Direccion.transferir(direccionDto));
        return new ResponseEntity<>(DireccionDto.transferir(direccionModificada), HttpStatus.OK);
    }
}
