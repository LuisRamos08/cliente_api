package com.luis.ramos.cliente_api.controller;

import com.luis.ramos.cliente_api.model.Cliente;
import com.luis.ramos.cliente_api.model.Direccion;
import com.luis.ramos.cliente_api.model.dto.ClienteDto;
import com.luis.ramos.cliente_api.model.dto.DireccionDto;
import com.luis.ramos.cliente_api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping(value = "/guardar")
    public ResponseEntity<ClienteDto> guardarCliente(@RequestBody ClienteDto clienteDto){
        Cliente cliente = clienteService.guardarCliente(Cliente.transferir(clienteDto));
        return new ResponseEntity<>(ClienteDto.transferir(cliente), HttpStatus.OK);
    }

    @GetMapping(value = "/buscarTodos")
    public ResponseEntity<List<ClienteDto>> buscarClientes(){
        List<Cliente> clientes = clienteService.buscarClientes();
        List<ClienteDto> clientesDto = clientes.stream().map(ClienteDto::transferir).collect(Collectors.toList());
        return new ResponseEntity<>(clientesDto,HttpStatus.OK);
    }

    @GetMapping(value = "/buscar/{id}")
    public ResponseEntity<ClienteDto> buscarCliente(@PathVariable final Long id){
        Cliente cliente = clienteService.buscarCliente(id);
        return new ResponseEntity<>(ClienteDto.transferir(cliente), HttpStatus.OK);
    }

    @DeleteMapping(value = "/eliminar/{id}")
    public ResponseEntity<ClienteDto> eliminarCliente(@PathVariable final Long id){
        Cliente cliente = clienteService.eliminarCliente(id);
        return new ResponseEntity<>(ClienteDto.transferir(cliente), HttpStatus.OK);
    }

    @PutMapping(value = "/modificar/{id}")
    public ResponseEntity<ClienteDto> modificarCliente(@PathVariable final Long id,
                                                       @RequestBody final ClienteDto clienteDto){
        Cliente clienteModificado = clienteService.modificarCliente(id,Cliente.transferir(clienteDto));
        return new ResponseEntity<>(ClienteDto.transferir(clienteModificado), HttpStatus.OK);
    }

   /* @PostMapping(value = "{clienteId}/direcciones/{direccionId}/agregar")
    public ResponseEntity<ClienteDto> agregarDirecccionACliente(@PathVariable final Long clienteId,
                                                                @PathVariable final Long direccionId){
        Cliente cliente = clienteService.agregarDireccionACliente(clienteId,direccionId);
        return new ResponseEntity<>(ClienteDto.transferir(cliente), HttpStatus.OK);
    }

    @DeleteMapping(value = "{clienteId}/direcciones/{direccionId}/eliminar")
    public ResponseEntity<ClienteDto> eliminarDirecccionACliente(@PathVariable final Long clienteId,
                                                                @PathVariable final Long direccionId){
        Cliente cliente = clienteService.eliminarDireccionACliente(clienteId,direccionId);
        return new ResponseEntity<>(ClienteDto.transferir(cliente), HttpStatus.OK);
    }*/
}
