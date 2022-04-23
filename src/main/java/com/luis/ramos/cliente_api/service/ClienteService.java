package com.luis.ramos.cliente_api.service;

import com.luis.ramos.cliente_api.model.Cliente;
import com.luis.ramos.cliente_api.model.Direccion;
import com.luis.ramos.cliente_api.model.exception.ClienteNotFoundException;
import com.luis.ramos.cliente_api.model.exception.DireccionIsAlreadyAssignedException;
import com.luis.ramos.cliente_api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final DireccionService direccionService;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository, DireccionService direccionService) {
        this.clienteRepository = clienteRepository;
        this.direccionService = direccionService;
    }

    public Cliente guardarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<Cliente> buscarClientes(){
        return StreamSupport
                .stream(clienteRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    public Cliente buscarCliente(Long id){
        return clienteRepository.findById(id).orElseThrow(()->
                new ClienteNotFoundException(id));
    }

    public Cliente eliminarCliente(Long id){
        Cliente cliente = this.buscarCliente(id);
        clienteRepository.delete(cliente);
        return cliente;
    }

    @Transactional
    public Cliente modificarCliente(Long id, Cliente cliente){

        Cliente clienteToEdit = this.buscarCliente(id);
        clienteToEdit.setNombre(cliente.getNombre());
        clienteToEdit.setApellido(cliente.getApellido());
        clienteToEdit.setEdad(cliente.getEdad());
        clienteToEdit.setTelefono(cliente.getTelefono());

        return clienteToEdit;
    }

    @Transactional
    public Cliente agregarDireccionACliente(Long clienteId, Long direccionId){
        Cliente cliente = this.buscarCliente(clienteId);
        Direccion direccion = direccionService.buscarDireccion(direccionId);

        if(Objects.nonNull(direccion.getCliente())){
            throw new DireccionIsAlreadyAssignedException(direccionId,direccion.getCliente().getCliente_id());
        }

        cliente.agregarDireccion(direccion);

        return cliente;
    }

    @Transactional
    public Cliente eliminarDireccionACliente(Long clienteId, Long direccionId){
        Cliente cliente = this.buscarCliente(clienteId);
        Direccion direccion = direccionService.buscarDireccion(direccionId);

        cliente.quitarDireccion(direccion);

        return cliente;
    }

}
