package com.luis.ramos.cliente_api;

import com.luis.ramos.cliente_api.model.Cliente;
import com.luis.ramos.cliente_api.model.Direccion;
import com.luis.ramos.cliente_api.repository.ClienteRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ClienteApiApplication {

	public static void main(String[] args) {

		try {
			SpringApplication.run(ClienteApiApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}

		//ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(ClienteApiApplication.class, args);
		/*ClienteRepository clienteRepository = configurableApplicationContext.getBean(ClienteRepository.class);

		Cliente cliente = new Cliente("Luis","Ramos",24,"809-205-0956");
		Direccion direccion1 = new Direccion("Nagua",cliente);
		Direccion direccion2 = new Direccion("Santo Domingo",cliente);
		List<Direccion> direccionList = Arrays.asList(direccion1,direccion2);
		cliente.setDirecciones(direccionList);

		clienteRepository.save(cliente);
		clienteRepository.delete(cliente);*/
	}

}
